# Cinemille Backend Application

Cinemille is a backend application built with Spring Boot designed to check the actual movies scheduling, including the expired ones.

## Table of Contents

- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Configuration](#configuration)
- [Running the Application](#running-the-application)
- [Testing](#testing)
- [API Documentation](#api-documentation)
- [Contributing](#contributing)
  
## Prerequisites

Before you begin, ensure you have met the following requirements:

- **Java Development Kit (JDK) 17 or higher**: Download and install from [Oracle](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html) or [OpenJDK](https://jdk.java.net/17/).
- **Apache Maven 3.8.1 or higher**: Download and install from [Maven](https://maven.apache.org/download.cgi).
- **MariaDB Server**: Ensure you have MariaDB installed and running. You can download it from [MariaDB](https://mariadb.org/download/).
- **Git**: Ensure Git is installed to clone the repository. Download from [Git](https://git-scm.com/downloads).

## Installation

1. **Clone the repository**:

     ```bash
     git clone https://github.com/your-username/cinemille_BE.git
     cd cinemille_BE
Install Maven dependencies:

    mvn clean install
## Configuration
1. **Database Configuration**:

Create a database in MariaDB:
    ```sql
    
    CREATE DATABASE cinemille;
2. Check the **application.properties** file located in src/main/resources for the database configuration:

    ```properties
   spring.datasource.url=jdbc:mariadb://localhost:3306/cinemille
   spring.datasource.username=cinemille
   spring.datasource.password=cinemille
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MariaDBDialect
3. Add the MariaDB dependency in your pom.xml file if it's not already present:

    ```xml
      <dependency>
        <groupId>org.mariadb.jdbc</groupId>
        <artifactId>mariadb-java-client</artifactId>
        <version>2.7.2</version>
      </dependency>
## Running the Application

1. Start the Spring Boot application:

    ```xml
    mvn spring-boot:run
The application should now be running on http://localhost:8080.

2. Populate the database using the **cinemille.sql** script in the project root folder


3. Testing
To run tests, use the following Maven command:

    ```xml
    mvn test
## API Documentation

The API documentation is generated using Swagger. Once the application is running, you can access the Swagger UI at:

http://localhost:8080/swagger-ui.html

## Contributing
1. Fork the repository.
2. Create a new branch **(git checkout -b feature-branch)**.
3. Make your changes.
4. Commit your changes **(git commit -m 'Add some feature')**.
5. Push to the branch **(git push origin feature-branch)**.
6. Create a new Pull Request.
