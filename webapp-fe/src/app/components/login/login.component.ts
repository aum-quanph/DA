import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-login',
  imports: [ReactiveFormsModule, CommonModule, RouterLink,],
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss',
})
export class LoginComponent {
  LoginForm = new FormGroup({
    userName: new FormControl('', Validators.required),
    password: new FormControl('', [Validators.required, Validators.minLength(6)]),
  });

  onSubmit() {
    if(this.LoginForm.valid) {
      const formData = this.LoginForm.value;
      const userName = formData.userName;
      const password = formData.password;

      alert('Đăng nhập thành công: \n' + 'User Name: ' + userName + '\n' + 'Password: ' + password);
    }

  }
}
