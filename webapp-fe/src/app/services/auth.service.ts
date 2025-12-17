import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { RegisterDTO } from '../dtos/user/register.dto';
import { UserResponse } from '../responses/user/user.response';
import { LoginDTO } from '../dtos/user/login.dto';
import { LoginResponse } from '../responses/user/login.response';
import { environment } from '../components/utils/appInfor';

export interface Register {
  userName: string;
  phoneNumber: string;
  email: string;
  password: string;
}

export interface Login {
  userName: string;
  password: string;
}


@Injectable({
  providedIn: 'root',
})

export class AuthService {
    constructor(private http: HttpClient) {}

    register(data: RegisterDTO): Observable<UserResponse> {
      debugger
      return this.http.post<UserResponse>(`${environment.apiUrl}/users/register`, data);
    }

    login(data: LoginDTO): Observable<LoginResponse> {
      debugger
      return this.http.post<LoginResponse>(`${environment.apiUrl}/users/login`, data);
    }
}

