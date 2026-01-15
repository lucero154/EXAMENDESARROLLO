import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-register',
  standalone: true, // <- Hacerlo standalone
  imports: [CommonModule, FormsModule],
  templateUrl: './register.component.html'
})
export class RegisterComponent {
  username = '';
  password = '';
  message = '';

  constructor(private authService: AuthService) {}

  register() {
    this.authService.register({
      username: this.username,
      password: this.password
    }).subscribe({
      next: () => {
        this.message = 'Usuario registrado correctamente';
      },
      error: () => {
        this.message = 'Error al registrar';
      }
    });
  }
}
