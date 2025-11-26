import { Component } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule, Validators} from '@angular/forms';

@Component({
  selector: 'app-register',
  imports: [ReactiveFormsModule],
  templateUrl: './register.component.html',
  styleUrl: './register.component.scss',
})
export class RegisterComponent {
  registerForm = new FormGroup({
    userName: new FormControl('', Validators.required),
    phoneNumber: new FormControl('', [Validators.required, Validators.minLength(3)]),
    email: new FormControl('', Validators.email),
    dateOfBirth: new FormControl('', Validators.required),
    password: new FormControl('', [Validators.required, Validators.minLength(6)]),
    confirmPassword: new FormControl('', [Validators.required, Validators.minLength(6)])
  });

  onSubmit() {
    alert('Đăng ký thành công!');
  }
}
