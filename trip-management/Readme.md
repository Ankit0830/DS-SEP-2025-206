# Trip Management Application

This is a Spring Boot application built with Hibernate (JPA) and MySQL for managing Trips. The system supports CRUD operations, search, filtering, pagination, validation, exception handling, and API documentation.

---

## Technologies Used

- Java 21
- Spring Boot 3.x
- Spring Data JPA / Hibernate
- MySQL Database
- Maven Build Tool
- Swagger / OpenAPI for API documentation
- JUnit & Mockito for Unit Testing

---

## Prerequisites

- Java 21 or above installed
- MySQL server running
- Maven installed
- Git installed

---

## Setup & Running the Application

### 1. Clone the Repository


### 2. Create Database

Create the MySQL database required by the project either by running the provided `tripdb.sql` script or manually:


### 3. Configure Database Credentials

Update the database connection in `src/main/resources/application.properties`:


The application will start on [http://localhost:8080](http://localhost:8080).

---

## API Endpoints Overview

| Method | URL                  | Description                               |
|--------|----------------------|-------------------------------------------|
| POST   | /api/trips           | Create a new trip                         |
| GET    | /api/trips           | Get all trips (with pagination & sorting)|
| GET    | /api/trips/{id}      | Get trip details by ID                    |
| PUT    | /api/trips/{id}      | Update a trip by ID                       |
| DELETE | /api/trips/{id}      | Delete a trip by ID                       |
| GET    | /api/trips/search    | Search trips by destination              |
| GET    | /api/trips/filter    | Filter trips by status                    |
| GET    | /api/trips/daterange | Get trips between start and end dates    |
| GET    | /api/trips/summary   | Get summary: total trips, min/max/avg price|

---

## API Documentation

Swagger API docs are available at:  
[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html) or  
[http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

---

## Testing

Unit tests are included using JUnit and Mockito. Run tests with:


---

## Postman Collection

A Postman collection is provided for testing all APIs.

---

## Project Structure

- `src/main/java/com/example/trip_management`  
  - Entities, Controllers, Services, Repositories, DTOs  
- `src/main/resources`  
  - `application.properties`, database scripts  
- `pom.xml` - Maven dependencies and build config  

---

## Author

Your Name / Registration Number

---

## License

This project is for academic use only.

## Steps to Run the Application

1. **Clone the Repository**
    ```bash
    git clone <repository-url>
    cd trip-management
    ```

2. **Install Dependencies**
    ```bash
    npm install
    # or
    yarn install
    ```

3. **Configure Environment Variables**
    - Create a `.env` file in the root directory.
    - Add necessary environment variables (e.g., database connection, API keys).

4. **Run Database Migrations (if applicable)**
    ```bash
    npm run migrate
    # or
    yarn migrate
    ```

5. **Start the Application**
    ```bash
    npm start
    # or
    yarn start
    ```

6. **Access the Application**
    - The server will typically run on `http://localhost:3000` (check your configuration).

---

## API Endpoints

### 1. Create a Trip
- **POST** `/api/trips`
- **Request Body Example:**
  ```json
  {
     "destination": "Paris",
     "startDate": "2024-07-01",
     "endDate": "2024-07-10",
     "participants": ["user1", "user2"]
  }
  ```
- **Response Example:**
  ```json
  {
     "id": "123",
     "destination": "Paris",
     "startDate": "2024-07-01",
     "endDate": "2024-07-10",
     "participants": ["user1", "user2"]
  }
  ```

### 2. Get All Trips
- **GET** `/api/trips`
- **Response Example:**
  ```json
  [
     {
        "id": "123",
        "destination": "Paris",
        "startDate": "2024-07-01",
        "endDate": "2024-07-10"
     },
     {
        "id": "124",
        "destination": "London",
        "startDate": "2024-08-01",
        "endDate": "2024-08-05"
     }
  ]
  ```

### 3. Get Trip by ID
- **GET** `/api/trips/{id}`
- **Response Example:**
  ```json
  {
     "id": "123",
     "destination": "Paris",
     "startDate": "2024-07-01",
     "endDate": "2024-07-10",
     "participants": ["user1", "user2"]
  }
  ```

### 4. Update a Trip
- **PUT** `/api/trips/{id}`
- **Request Body Example:**
  ```json
  {
     "destination": "Rome",
     "startDate": "2024-07-05",
     "endDate": "2024-07-15"
  }
  ```
- **Response Example:**
  ```json
  {
     "id": "123",
     "destination": "Rome",
     "startDate": "2024-07-05",
     "endDate": "2024-07-15"
  }
  ```

### 5. Delete a Trip
- **DELETE** `/api/trips/{id}`
- **Response Example:**
  ```json
  {
     "message": "Trip deleted successfully"
  }
  ```
