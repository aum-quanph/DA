import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { Router, RouterLink } from '@angular/router';
import { AuthService } from '../../services/auth/auth.service';
import { LoginDTO } from '../../dtos/user/login.dto';

@Component({
  selector: 'app-login',
  imports: [ReactiveFormsModule, CommonModule, RouterLink,],
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss',
})
export class LoginComponent {
  LoginForm: FormGroup;
  errorMessage: string = '';

  constructor(
    private router: Router,
    private auth: AuthService,
    private fb: FormBuilder) {
    this.LoginForm = this.fb.nonNullable.group({
      username: ['', Validators.required],
      password: ['', [Validators.required]],
    })
  }

  onSubmit() {
    if (this.LoginForm.invalid) {
      this.LoginForm.markAllAsTouched();
      return;
    }

    const data = this.LoginForm.getRawValue() as LoginDTO;
    this.auth.login(data).subscribe({
      next: (res) => {
        localStorage.setItem('access_token', res.token ?? '');
        localStorage.setItem('current_user', JSON.stringify(res.user));
        console.log('response: ', res);
        setTimeout(() => {
          this.router.navigate(['/home']);
        }, 3000)
        alert('Đăng nhập thành công, đang chuyển tới trang Home trong 3s.')
      },
      error: (err) => {
        this.errorMessage = err.error || 'Login failed, please try again.';
      }
    })
  }
}
