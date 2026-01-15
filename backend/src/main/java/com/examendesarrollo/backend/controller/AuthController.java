package com.examendesarrollo.backend.controller;

import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import com.examendesarrollo.backend.dto.*;
import com.examendesarrollo.backend.model.User;
import com.examendesarrollo.backend.security.JwtUtil;
import com.examendesarrollo.backend.service.UserService;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

    private final UserService userService;
    private final JwtUtil jwtUtil;
    private final BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {

        User user = userService.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            return ResponseEntity.status(401).body("Credenciales incorrectas");
        }

        String token = jwtUtil.generateToken(user.getUsername());

        return ResponseEntity.ok(new LoginResponse(token));
    }

    @PostMapping("/register")
public ResponseEntity<?> register(@RequestBody RegisterRequest request) {

    User user = new User();
    user.setUsername(request.getUsername());
    user.setPassword(passwordEncoder.encode(request.getPassword())); // 🔐 clave aquí
    user.setRole("USER");

    userService.save(user);

    return ResponseEntity.ok("Usuario registrado correctamente");
}

}