package com.examendesarrollo.backend.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.examendesarrollo.backend.model.User;
import com.examendesarrollo.backend.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }
}
