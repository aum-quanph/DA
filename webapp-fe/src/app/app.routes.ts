import { Routes } from '@angular/router';
import { RegisterComponent } from './components/register/register.component';
import { LoginComponent } from './components/login/login.component';
import { HomeComponent } from './components/home/home.component';

export const routes: Routes = [
  { path: '', redirectTo: '/login', pathMatch: 'full' }, 
  { path: 'home', component: HomeComponent, title: 'App Home' },
  { path: 'login', component: LoginComponent, title: 'App Login' },
  { path: 'register', component: RegisterComponent, title: 'App Register' },
];

