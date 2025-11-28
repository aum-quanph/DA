export interface UserResponse {
  id: number;
  firstName: string;
  lastName: string;
  userName: string;
  phoneNumber: string;
  email: string | null;
  dateOfBirth: string | null;
}
