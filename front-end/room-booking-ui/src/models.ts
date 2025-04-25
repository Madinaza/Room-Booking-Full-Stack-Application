export interface Room {
  id: number; name: string; location?: string; capacity?: number;
}
export interface Booking {
  id: number; userId: number; roomId: number;
  startTime: string; endTime: string;
}
export interface AuthResponse { token: string; }
