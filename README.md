# Stackoverflow Project Overview

During our Teamwork week in the Object-Oriented Programming module, we developed Stackoverflow clone Spring Boot Web API, inspired by the popular Stackoverflow site. This project serves as our final team project, focusing on Java and Spring Boot technologies. This repository only focuses on the backend side of the application, the [fronted](https://github.com/korodigergo/stackflow-react3) can be found in a separate repository.

## Project Description

Stackoverflow enables users to create new questions, post answers, and manage their questions and answers. The technology stack includes:

- Backend: Java (Spring Boot 3) for handling requests and responses.
- Database: PostgreSQL for efficient data management.

## Installation Guide

Project Setup


### 1. Clone this repository:

   ```bash
   git clone https://github.com/tolnabert/stackoverflow.git
   ```

### 2. Database Configuration:

  - Set up the database connection by configuring environmental variables in the project:
  - Add POSTGRES_USER, POSTGRES_PASSWORD, and POSTGRES_URL to your environment variables.

### 3. Navigate to the project directory:

   ```bash
   cd stackoveflow
   ```

### 4. Build the project using Maven:

   ```bash
   mvn clean package
   ```

### 5. Run the application:

   ```bash
   java -jar target/stackoverflow.jar
   ```

### Features

- Register with fictional information (username and password).
- Login to the site.
- Post new questions.
- Post new answers.
- Manage your questions by deleting them.
- Manage your answers by deleting them.
