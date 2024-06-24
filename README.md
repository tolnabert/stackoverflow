<a name="readme-top"></a>
<!-- PROJECT SHIELDS -->
[![Contributors][contributors-shield]][contributors-url]

<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#stackoverflow-project-overview">Stackoverflow Project Overview</a>
    </li>
    <li>
      <a href="#project-description">Project Description</a>
      <ul>
        <li>
           <a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li><a href="#installation-guide">Installation Guide</a></li>
    <li><a href="#features">Features</a></li>
  </ol>
</details>

## Stackoverflow Project Overview

During our Teamwork week in the Object-Oriented Programming module, we developed Stackoverflow clone Spring Boot Web API, inspired by the popular Stackoverflow site. This project serves as our final team project, focusing on Java and Spring Boot technologies. This repository only focuses on the backend side of the application, the [fronted](https://github.com/korodigergo/stackflow-react3) can be found in a separate repository.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

## Project Description

Stackoverflow enables users to create new questions, post answers, and manage their questions and answers. The technology stack includes:

- Backend: Java (Spring Boot 3) for handling requests and responses.
- Database: PostgreSQL for efficient data management.


### Built With

* [![PostgreSQL][PostgreSQL.org]][PostgreSQL-url]
* [![Spring][Spring.io]][Spring-url]

<p align="right">(<a href="#readme-top">back to top</a>)</p>

## Installation Guide

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

<p align="right">(<a href="#readme-top">back to top</a>)</p>

## Features

- Register with fictional information (username and password).
- Login to the site.
- Post new questions.
- Post new answers.
- Manage your questions by deleting them.
- Manage your answers by deleting them.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- MARKDOWN LINKS & IMAGES -->
[Spring-url]: https://spring.io/projects/spring-boot
[Spring.io]: https://img.shields.io/badge/Sring%20Boot-%236DB33F?style=for-the-badge&logo=springboot&logoColor=white
[PostgreSQL-url]: https://www.postgresql.org/
[PostgreSQL.org]: https://img.shields.io/badge/Postgre%20SQL-%234169E1?style=for-the-badge&logo=postgresql&logoColor=white
[contributors-shield]: https://img.shields.io/github/contributors/tolnabert/stackoverflow.svg?style=for-the-badge
[contributors-url]: https://github.com/tolnabert/stackoverflow/graphs/contributors
