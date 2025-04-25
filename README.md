# Room Booking System

A robust, secure, and real-time room booking backend built with Spring Boot.  
Users can register, authenticate via JWT, browse available rooms, create or cancel bookings—and receive live updates over WebSockets.

---

## 🚀 Key Features

- **User Management**  
  - Registration & login endpoints  
  - Password hashing & role-based access (USER / ADMIN)

- **JWT Security**  
  - Token issuance on login  
  - Filter-based validation for protected routes  

- **Room & Booking APIs**  
  - Browse available rooms  
  - CRUD operations on bookings  
  - Validation to prevent overlapping reservations  

- **Real-Time Notifications**  
  - STOMP over WebSocket  
  - Broadcast booking events to connected clients  

- **Developer Experience**  
  - In-memory H2 database with console (`/h2-console`)  
  - SQL seed script for initial room data  
  - Detailed logs of SQL statements and security filters  

---

## 🛠 Tech Stack

| Category       | Technology                                          |
| -------------- | --------------------------------------------------- |
| Language       | Java 17                                              |
| Framework      | Spring Boot (Web, Security, Data JPA, WebSocket)     |
| Database       | H2 (in-memory) + console                            |
| Security       | Spring Security + **jjwt** (JWT)                    |
| Mapping        | MapStruct                                           |
| Build & CI     | Maven                                                |
| Real-Time      | STOMP over WebSocket                                |


