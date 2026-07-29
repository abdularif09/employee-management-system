# employee-management-system
employee-management-system
# Employee Management System - Microservices Architecture

## Overview

This project demonstrates a complete enterprise-style Employee Management System built using a Microservices architecture.

The application is designed to showcase modern Java backend development using Spring Boot, Spring Security, JWT Authentication, API Gateway, Camunda 7, Docker, and MySQL.

This project was developed as part of my transition from OpenText AppWorks to Spring Boot Microservices.

---

## Architecture

```
                Client
                   |
            API Gateway
                   |
     ----------------------------
     |            |            |
 Authentication  Employee   Camunda
    Service      Service    Service
                   |
                MySQL
```

---

## Microservices

### 1. API Gateway

Responsibilities

- Centralized routing
- Request forwarding
- Load balancing
- Entry point for all APIs

Technology

- Spring Cloud Gateway

---

### 2. Authentication Service

Responsibilities

- User Registration
- Login
- JWT Token Generation
- Role-Based Authentication
- Password Encryption

Technology

- Spring Boot
- Spring Security
- JWT
- Spring Data JPA

---

### 3. Employee Service

Responsibilities

- Employee CRUD
- Validation
- Pagination
- Exception Handling

Technology

- Spring Boot
- Hibernate
- JPA
- MySQL

---

### 4. Camunda Workflow Service

Responsibilities

- BPMN Workflow
- User Tasks
- Service Tasks
- Process Variables
- REST Integration

Technology

- Camunda 7
- Spring Boot

---

## Technology Stack

- Java 17
- Spring Boot
- Spring Security
- Spring Data JPA

- Spring Cloud Gateway
- JWT Authentication
- Camunda 7
- BPMN 2.0
- Docker
- Docker Compose
- Maven
- MySQL
- Git
- GitHub

---

## Features

- JWT Authentication
- Secure REST APIs
- API Gateway
- Employee CRUD
- Camunda Workflow
- Dockerized Services
- Layered Architecture

- Enterprise Project Structure

---

## Project Structure

```
employee-management-system

├── api-gateway
├── authentication-service
├── employee-service
├── camunda-service
├── docker-compose.yml
└── README.md
```

---

## Running the Project

### Clone Repository

```bash
git clone https://github.com/<your-username>/employee-management-system.git
```

### Build

```bash
mvn clean install
```

### Start Docker

```bash
docker-compose up
```

---

## API Endpoints

Authentication

```
POST /auth/register
POST /auth/login
```

Employee

```
GET    /employees
GET    /employees/{id}
POST   /employees
PUT    /employees/{id}
DELETE /employees/{id}
```

Camunda

```
POST /process/start
GET  /process/tasks
POST /process/complete
```

---

## Future Enhancements

- Service Discovery
- Config Server
- Kafka Integration
- Redis Cache
- Kubernetes Deployment
- Prometheus
- Grafana

---

## Author

Arif Abdul Shaik

Senior Software Engineer

Java | Spring Boot | OpenText AppWorks | Microservices | Camunda 7

LinkedIn:
https://www.linkedin.com/in/arif-abdul-67298651

GitHub:
https://github.com/<your-username>
