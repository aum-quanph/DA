import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Register {
    firtname: string;
    lastname: string;
    username: string;
    phone_number: string;
    email: string;
    password: string;
    confirm_password: string;
    date_of_birth: Date;
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

    register(body: Register) {
        return this.http.post(`${this.apiUrl}/register`, body);
    }

    login(body: Login) {
    return this.http.post(`${this.apiUrl}/login`, body);
  }
}

