import { Routes } from '@angular/router';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';

export const routes: Routes = [
    {path: '', redirectTo: '/home', pathMatch: 'full'},
    {path: 'home', component: HomeComponent, title: 'App Home'},
    {path: 'login', component: LoginComponent, title: 'App Login'},
    {path: 'register', component: RegisterComponent, title: 'App Register'},
];
