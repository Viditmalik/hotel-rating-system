# 🏨 Hotel Rating Microservices System

A production-ready microservices-based backend system built using Spring Boot and Spring Cloud.

---

## 🚀 Tech Stack

* Java, Spring Boot
* Spring Cloud (Eureka, Config Server, API Gateway)
* OpenFeign (Service-to-Service Communication)
* Resilience4j (Circuit Breaker, Retry, Rate Limiter)
* Spring Security + OAuth2 (Okta)
* JWT Authentication

---

## 🧩 Microservices

* **User Service**
* **Hotel Service**
* **Rating Service**
* **API Gateway**
* **Service Registry (Eureka)**
* **Config Server**

---

## 🔐 Security Implementation

* Okta-based authentication
* JWT-secured API Gateway
* Token Relay between services
* Each microservice secured as OAuth2 Resource Server

---

## 🔁 Fault Tolerance (Resilience4j)

* Circuit Breaker
* Retry Mechanism
* Rate Limiting
* Fallback Methods

---

##  Architecture Flow

1. Client → API Gateway
2. Gateway → Microservices (Feign Client)
3. Services communicate via DTO
4. Token propagated across services

---

## ⚙️ Run Order

1. Config Server
2. Eureka Server
3. All Microservices
4. API Gateway

---

## 👨‍💻 Author

**Vidit Malik**
