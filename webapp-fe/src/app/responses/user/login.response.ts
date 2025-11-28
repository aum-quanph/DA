import { UserResponse } from './user.response';

export interface LoginResponse {
  token: string | null;
  user: UserResponse | null;
  message: string;
}