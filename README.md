# 🏨 Hotel Rating System – Production Ready Microservices Architecture

A production-ready Hotel Rating System built using Spring Boot, Spring Cloud, Docker, Kubernetes, Redis, Apache Kafka, and AWS following Microservices Architecture principles.

This project demonstrates secure REST APIs, distributed system design, centralized configuration, service discovery, inter-service communication, event-driven architecture, caching, containerization, Kubernetes orchestration, and cloud deployment.

---

# 📌 Architecture Diagram

Complete architecture of the Hotel Rating System.

<p align="center">
  <img src="images/architecture.jpeg" alt="Hotel Rating System Architecture" width="100%">
</p>

---

# 🚀 Features

- Microservices Architecture
- API Gateway
- Eureka Service Discovery
- Spring Cloud Config Server
- OpenFeign Client Communication
- DTO-based Communication
- OAuth2 Authentication (Okta)
- JWT Authentication
- Token Relay
- Resilience4j
  - Circuit Breaker
  - Retry
  - Rate Limiter
- Redis Caching
- Apache Kafka Event-Driven Communication
- Docker Containerization
- Docker Compose Orchestration
- Kubernetes Deployment
- Kubernetes Services
- NodePort Services
- AWS EC2 Deployment
- Amazon RDS
- AWS IAM
- AWS VPC
- AWS S3
- AWS CloudWatch
- MySQL Database

---

# 🛠 Tech Stack

## Backend

- Java 17
- Spring Boot
- Spring Cloud
- Spring Security
- Spring Data JPA
- Hibernate
- Maven

## Microservices

- API Gateway
- Eureka Server
- Config Server
- OpenFeign
- Resilience4j

## Security

- OAuth2
- Okta
- JWT Authentication
- Token Relay

## Database & Cache

- MySQL
- Amazon RDS
- Redis

## Messaging

- Apache Kafka

## DevOps & Cloud

- Docker
- Docker Compose
- Kubernetes
- Minikube
- kubectl
- AWS EC2
- AWS IAM
- AWS VPC
- AWS S3
- AWS CloudWatch

---

# 🧩 Microservices

## User Service

Responsible for

- User CRUD Operations
- OAuth2 Resource Server
- OpenFeign Client Communication
- Resilience4j
- Redis Integration

---

## Hotel Service

Responsible for

- Hotel CRUD Operations
- Redis Caching
- Kafka Consumer
- OAuth2 Resource Server
- OpenFeign Client

---

## Rating Service

Responsible for

- Rating CRUD Operations
- Kafka Producer
- OAuth2 Resource Server
- OpenFeign Client

---

## Infrastructure Services

- API Gateway
- Eureka Service Registry
- Config Server

---

# 🔐 Security

- OAuth2 Authentication using Okta
- JWT Validation
- API Gateway Security
- Token Relay Across Services
- OAuth2 Resource Server

---

# ⚡ Redis Implementation

Redis is used to cache hotel information.

## Benefits

- Faster API Response
- Reduced Database Load
- Improved Performance
- Better Scalability

---

# 📩 Kafka Event Flow

```
Client
   │
   ▼
Rating Service
   │
Save Rating
   │
   ▼
Kafka Producer
   │
Publish Event
   │
   ▼
rating-created-topic
   │
   ▼
Kafka Broker
   │
   ▼
Hotel Service Consumer
(@KafkaListener)
   │
   ▼
Processes Rating Event
```

---

# 🐳 Docker Implementation

Every microservice is containerized using Docker.

Docker Compose manages

- API Gateway
- Eureka Server
- Config Server
- User Service
- Hotel Service
- Rating Service
- MySQL
- Redis
- Kafka
- Zookeeper

---

# ☸️ Kubernetes Deployment

The complete Hotel Rating System has been deployed on Kubernetes using Minikube.

Each microservice runs inside its own Pod and communicates using Kubernetes Services.

## Kubernetes Components Used

- Deployments
- Pods
- Services
- NodePort
- ReplicaSets
- Labels & Selectors
- kubectl
- Minikube

## Deployed Services

- API Gateway
- Eureka Server
- Config Server
- User Service
- Hotel Service
- Rating Service

---

# ☁️ AWS Deployment

The application has been deployed on AWS using production-style cloud infrastructure.

## AWS Services Used

- Amazon EC2
- Amazon RDS (MySQL)
- AWS IAM
- AWS VPC
- AWS S3
- AWS CloudWatch

---

# 📂 Project Structure

```
Hotel_Rating_System
│
├── ApiGateway/
├── ConfigServer/
├── HotelService/
├── RatingService/
├── ServiceRegistry/
├── UserService/
│
├── k8s/
│   └── manifests/
│       ├── service-registry-deployment.yaml
│       ├── service-registry-service.yaml
│       ├── config-server-deployment.yaml
│       ├── config-server-service.yaml
│       ├── user-service-deployment.yaml
│       ├── user-service-service.yaml
│       ├── hotel-service-deployment.yaml
│       ├── hotel-service-service.yaml
│       ├── rating-service-deployment.yaml
│       ├── rating-service-service.yaml
│       ├── api-gateway-deployment.yaml
│       └── api-gateway-service.yaml
│
├── docker-compose.yml
├── docker-compose-kafka.yml
├── README.md
│
└── images/
    └── architecture.jpeg
```

---

# ▶️ Demo Video

🎥 Project Walkthrough

The demonstration includes

- Microservices Architecture
- API Gateway
- Eureka Service Discovery
- Config Server
- User Service
- Hotel Service
- Rating Service
- OAuth2 Authentication
- OpenFeign Communication
- Resilience4j

📹 Demo Video

https://drive.google.com/file/d/1aDHi9iDGALD88H8rpDgz6-1b4SAiInAn/view

**Note**

The demo video was recorded before integrating Redis, Apache Kafka, Docker Compose improvements, Kubernetes deployment, and AWS cloud deployment.

The latest implementation available in this repository includes all these enhancements.

---

# 📬 API Endpoints

## User Service

```
/users/**
```

## Hotel Service

```
/hotels/**
```

## Rating Service

```
/ratings/**
```

---

# 👨‍💻 Author

## Vidit Malik

Java Backend Developer

### Skills

- Java
- Spring Boot
- Spring Cloud
- Spring Security
- Spring Data JPA
- Hibernate
- OpenFeign
- Resilience4j
- Docker
- Docker Compose
- Kubernetes
- Minikube
- Redis
- Apache Kafka
- AWS
- MySQL

GitHub

https://github.com/Viditmalik

---

⭐ If you found this project helpful, please consider giving it a Star.
