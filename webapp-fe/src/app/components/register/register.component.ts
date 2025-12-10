import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import {
  FormBuilder,
  ReactiveFormsModule,
  Validators,
  FormGroup,
} from '@angular/forms';
import { RouterLink, Router } from '@angular/router';
import { AuthService } from '../../services/auth/auth.service';
import { RegisterDTO } from '../../dtos/user/register.dto';

export interface ErrorMessageResponse {
  timestamp: string;
  status: number;
  error: string;
  message: string;
}

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [ReactiveFormsModule, CommonModule, RouterLink],
  templateUrl: './register.component.html',
  styleUrl: './register.component.scss',
})
export class RegisterComponent {
  loading = false;
  errorMessage = '';
  registerForm: FormGroup;

  constructor(
    private authService: AuthService,
    private router: Router,
    private fb: FormBuilder,
  ) {

    this.registerForm = this.fb.nonNullable.group({
      first_name: ['', Validators.required],
      last_name: ['', Validators.required],
      username: ['', Validators.required],
      phone_number: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      date_of_birth: ['', Validators.required],
      password: ['', Validators.required],
      confirm_password: ['', Validators.required],
    });
  }

  onSubmit() {
    if (this.registerForm.invalid) {
      this.registerForm.markAllAsTouched();
      return;
    }

    const data = this.registerForm.getRawValue() as RegisterDTO;

    debugger
    this.authService.register(data).subscribe({
      next: () => {
        setTimeout(() => {
          this.router.navigate(['/login']);
        }, 3000);
        alert("Đăng ký thành công, Đang chuyển tới trang Đăng nhập.");
      },
      error: (err) => {
        this.errorMessage = err.error || 'Register failed, please try again.';
      },
    });
  }
}
