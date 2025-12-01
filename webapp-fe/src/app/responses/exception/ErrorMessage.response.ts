export interface ErrorMessageResponse {
  timestamp: string;
  status: number;
  error: string;
  message: string;
  path: string;
  field?: string;
}
