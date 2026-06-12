# Simple Library Management REST API

A basic REST API built with Spring Boot to manage a collection of books.

This project demonstrates the fundamental concepts of Spring Boot, including dependency injection, REST controllers, layered architecture, exception handling, and unit testing.

## Features

* Create a new book
* Retrieve all books
* Retrieve a book by its ID
* Update an existing book
* Delete a book
* In-memory storage using Java Collections (Map)
* JSON responses
* Unit tests with JUnit 5

## Technical Stack

* Java 21
* Spring Boot 3+
* Spring Web
* Spring Test
* JUnit 5
* Maven

## Project Structure

```text
src
├── main
│   ├── java
│   │   └── com.jfa.library_api
│   │       ├── controller
│   │       ├── service
│   │       ├── repository
│   │       ├── entity
│   │       ├── exception
│   │       └── advice
│   └── resources
└── test
    └── java
```

## API Endpoints

### Get all books

```http
GET /api/books
```

### Get a book by id

```http
GET /api/books/{id}
```

### Create a book

```http
POST /api/books
Content-Type: application/json

{
  "title": "Clean Code",
  "author": "Robert C. Martin",
  "year": 2008
}
```

### Update a book

```http
PUT /api/books/{id}
Content-Type: application/json

{
  "title": "Clean Code Updated",
  "author": "Robert C. Martin",
  "year": 2008
}
```

### Delete a book

```http
DELETE /api/books/{id}
```

## Running the Application

Clone the repository:

```bash
git clone https://github.com/Shoto974/simple_library_management_rest_api.git
```

Move into the project directory:

```bash
cd simple_library_management_rest_api
```

Run the application:

```bash
./mvnw spring-boot:run
```

The API will be available at:

```text
http://localhost:8080
```

## Running Tests

Run all tests with Maven:

```bash
./mvnw test
```

## Learning Objectives

This project was created to practice:

* Spring Boot fundamentals
* Dependency Injection (IoC)
* REST API development
* Layered architecture
* Exception handling
* Unit testing with JUnit 5

## Author

Jessy Fanguimache
