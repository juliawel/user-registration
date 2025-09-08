# User Registration API

This is a simple user registration API built with Spring Boot.

## Technologies Used

*   Java 24
*   Spring Boot 3.5.5
*   Spring Web
*   Spring Data JPA
*   Spring Security
*   Hibernate Validator
*   H2 Database
*   Lombok
*   Maven

## Getting Started

To get a local copy up and running, follow these simple steps.

### Prerequisites

*   JDK 24 or later
*   Maven 3.6.3 or later

### Installation & Running

1.  Clone the repo
    ```sh
    git clone https://github.com/your_username/user-registration.git
    ```
2.  Navigate to the project directory
    ```sh
    cd user-registration
    ```
3.  Run the application using Maven
    ```sh
    mvn spring-boot:run
    ```

The application will be available at `http://localhost:8080`.

## API Endpoints

The following API endpoints are available:

### `POST /user`

Registers a new user.

**Request Body:**

```json
{
  "name": "Test User",
  "email": "test@example.com",
  "password": "password123",
  "birthdate": "1990-01-01"
}
```

### `GET /user`

Retrieves a list of all users.

### `GET /user/search`

Finds a user by email.

**Query Parameter:**

*   `email`: The email of the user to find.

**Example:** `http://localhost:8080/user/search?email=test@example.com`

### `PUT /user/{id}`

Updates an existing user. The request body can contain any of the fields from the registration request.

**Path Variable:**

*   `id`: The UUID of the user to update.

**Request Body (Example):**

```json
{
  "name": "New Name"
}
```

**Example URL:** `http://localhost:8080/user/f47ac10b-58cc-4372-a567-0e02b2c3d479`

### `DELETE /user`

Deletes a user by email.

**Query Parameter:**

*   `email`: The email of the user to delete.

**Example:** `http://localhost:8080/user/delete?email=test@example.com`


## H2 Database

This project uses an in-memory H2 database for storage. The data is not persisted between application restarts.

### H2 Console

The H2 console is a web-based client that allows you to manage the database.

*   **URL:** `http://localhost:8080/h2-console`
*   **JDBC URL:** `jdbc:h2:mem:user`
*   **Username:** `test`
*   **Password:** (leave blank)

To access the console, open the URL in your browser and use the credentials above to log in.