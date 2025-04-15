# 🎬 Old Fashion Video Rental

A Java-based application inspired by classic video rental systems (like Blockbuster), reimagined with modern software practices. This project evolves through different stages — from basic JDBC implementation to Spring integration and Docker containerization.

## 📌 Project Overview

This app simulates a retro video rental store, applying Object-Oriented Programming (OOP), the MVC pattern, and relational database management. Each branch represents a different milestone in the development process, showcasing the evolution of both technical depth and architecture.

---

## 🚀 Project Versions (by Branch)

| Branch               | Description |
|----------------------|-------------|
| `main`               | Basic version using Java and JDBC. Implements MVC pattern, SQL database integration, and simple input validation. |
| `spring-jdbc`        | Refactored to use Spring Framework and JDBC Template. Improved modularity, structure, and maintainability. |
| `raw-jdbc`           | Highlights raw JDBC implementation with improved environment configuration using `.env` files and manual connection handling. Designed to separate concerns and simulate production-like setups. |
| `docker-integration` | Adds Docker support for containerized development and deployment. Prepares the app for scalable infrastructure. |
| `develop`            | Active development branch with ongoing improvements, testing, and upcoming features like REST API and microservices. |


## 🔧 Tech Stack

- Java
- JDBC / Spring JDBC
- SQL Database
- dotenv Java libraries for config
- Docker (WIP)

---

## 📦 How to Run

```bash
# Clone the repository
git clone https://github.com/Ignacioscript/video-rental.git

# Navigate to the project directory
cd video-rental

# Checkout the desired version/branch
git checkout spring-jdbc

# Follow specific README instructions within the branch (if available)
