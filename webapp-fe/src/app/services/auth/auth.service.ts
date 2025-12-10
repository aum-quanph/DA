import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { RegisterDTO } from '../../dtos/user/register.dto';
import { UserResponse } from '../../responses/user/user.response';
import { LoginDTO } from '../../dtos/user/login.dto';
import { LoginResponse } from '../../responses/user/login.response';

export interface Register {
  firstName: string;
  lastName: string;
  userName: string;
  phoneNumber: string;
  email: string;
  password: string;
  confirmPassword: string;
  dateOfBirth: string;
}

export interface Login {
  userName: string;
  password: string;
}


@Injectable({
  providedIn: 'root',
})

export class AuthService {
    private apiUrl = 'http://localhost:8088/api/v1/users';

    constructor(private http: HttpClient) {}

    register(data: RegisterDTO): Observable<UserResponse> {
      debugger
      return this.http.post<UserResponse>(`${this.apiUrl}/register`, data);
    }

    login(data: LoginDTO): Observable<LoginResponse> {
      debugger
      return this.http.post<LoginResponse>(`${this.apiUrl}/login`, data);
    }
}

