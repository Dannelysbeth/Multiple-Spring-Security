# Multiple Security Configurations with Spring Security

This repository contains a Spring Boot application demonstrating multiple security configurations, including HTTP Basic authentication for APIs, form-based login for the main web application, and relaxed security settings for the H2 database console.

## Project Structure

The project consists of the following key components:

1. **Security Configuration**: Defines the different security settings for APIs, web app, and H2 console.
2. **Controllers**: Provide REST endpoints for handling requests.
3. **Data Model and Repository**: Represent the data structure and handle database operations.

---

## Table of Contents

- [Getting Started](#getting-started)
- [Security Configuration](#security-configuration)
  - [API Security](#api-security)
  - [Web App Security](#web-app-security)
  - [H2 Console Security](#h2-console-security)
- [Endpoints](#endpoints)
- [Database](#database)
- [How to Run](#how-to-run)

---

## Getting Started

To start the application, clone the repository and run the following commands:

```bash
git clone https://github.com/your-username/multiple-security-app.git
cd multiple-security-app
./mvnw spring-boot:run
```

### Prerequisites

- Java 17 or higher
- Maven 3.6+
- H2 Database (embedded)

---

## Security Configuration

### Overview

The security is configured using three `SecurityFilterChain` beans that apply different security rules to specific paths. These filter chains have distinct orders to determine which one applies first.

### API Security

The `/api/**` endpoints require **Basic Authentication** with a stateless session.

- **Path**: `/api/**`
- **Authentication**: HTTP Basic
- **Session**: Stateless

### Web App Security

The root `/` and `/error` endpoints are publicly accessible, but all other endpoints require authentication via **form-based login**.


- **Path**: `/` and `/error` (public), all others (authentication required)
- **Authentication**: Form-based login

### H2 Console Security

To enable access to the H2 console, security is relaxed for the `/h2-console/**` path. CSRF protection is disabled for this route, and `X-Frame-Options` is also turned off to allow the H2 console to be displayed in iframes.


- **Path**: `/h2-console/**` (public)
- **Special Considerations**: CSRF disabled, X-Frame-Options disabled

---

## Endpoints

### Public Endpoints

1. **Home**: Accessible by anyone.
   - `GET /`
   - Response: `"Hello, World!"`

2. **Error**: Default error page (permitted).

### Secured Endpoints

1. **Private Endpoint**: Requires authentication.
   - `GET /private`
   - Response: `"secured"`

2. **API Endpoint**: Lists all posts (requires Basic Auth).
   - `GET /api/posts`
   - Response: JSON array of posts.

---

## Database

### H2 Console

The H2 database can be accessed via the `/h2-console` route. You can log in to the console to view the data in the in-memory database.

- **URL**: `/h2-console`
- **JDBC URL**: `jdbc:h2:mem:testdb`
- **Username**: `sa`
- **Password**: *(leave blank)*

### Data Model

The data model consists of a simple `Post` entity:

```java
public record Post(@Id Integer id, String title, String content) {}
```

The repository interface extends `ListCrudRepository` to provide CRUD operations.

---

## How to Run

1. Clone the repository and navigate to the project directory.
2. Run the application using:

```bash
./mvnw spring-boot:run
```

3. Access the following URLs:
   - **Home**: [http://localhost:8080/](http://localhost:8080/)
   - **H2 Console**: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)

4. Use **Basic Auth** to access `/api/posts` or log in via the form login for other secure pages.

---

## License

This project is licensed under the MIT License.
