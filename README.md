# 🎬 Old Fashion Video Rental

A Java-based application inspired by classic video rental systems (like Blockbuster), reimagined with modern software practices. This project evolves through different stages — from basic JDBC implementation to Spring integration and Docker containerization.

## 📌 Project Overview

This app simulates a retro video rental system, applying OOP, MVC, and database interaction through SQL. It is divided into multiple branches, each representing a milestone in the development journey.

---

## 🚀 Project Versions (by Branch)

| Branch              | Description |
|---------------------|-------------|
| `main`              | Basic version using Java and JDBC. Implements MVC, SQL database integration, and environment variable validation. |
| `spring-jdbc`       | Refactored version using Spring Framework for better structure and dependency management. |
| `raw-jdbc`          | Focused on externalizing configuration via `.env` file and Java environment management. |
| `docker-integration`| Adds Docker support for containerized development and deployment. |
| `develop`           | Active development branch — work in progress with planned features and refactoring. |

---

## 🔧 Tech Stack

- Java
- JDBC / Spring JDBC
- SQL Database
- .env config management
- Docker (in progress)

---

## 📦 How to Run

```bash
# Clone the repo
git clone https://github.com/Ignacioscript/video-rental.git

# Checkout desired version
git checkout spring-jdbc
