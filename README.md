# User Registration API

This is a simple user registration API built with Spring Boot.

## Features

*   User registration
*   User data validation
*   Password encryption
*   Persistence of user data in an H2 in-memory database

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

### Installation

1.  Clone the repo
    ```sh
    git clone https://github.com/your_username/user-registration.git
    ```
2.  Navigate to the project directory
    ```sh
    cd user-registration
    ```
3.  Build the project
    ```sh
    mvn clean install
    ```
4.  Run the application
    ```sh
    mvn spring-boot:run
    ```

The application will be available at `http://localhost:8080`.

## API Endpoints

The following API endpoints are available:

*   `POST /users/register`: Registers a new user.

**Request Body:**

```json
{
  "username": "testuser",
  "password": "password123",
  "email": "test@example.com"
}
```

**Response:**

```json
{
  "id": 1,
  "username": "testuser",
  "email": "test@example.com"
}
```

## Configuration

The application uses an in-memory H2 database by default. The configuration can be found in the `src/main/resources/application.properties` file.

*   **`spring.application.name`**: The name of the application.
