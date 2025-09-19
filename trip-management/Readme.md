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