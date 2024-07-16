# AppliHub

AppliHub is a job application API built with Spring Boot and PostgreSQL that allows users to manage their job application details. Users can submit their details, including last name, first name, date of birth, email address, and upload their curriculum vitae (CV). Users can also review, update, and delete their respective information.

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Prerequisites](#prerequisites)
- [Setup Instructions](#setup-instructions)
- [API Documentation](#api-documentation)
- [Contributing](#contributing)
- [License](#license)
- [Contact](#contact)

## Introduction

AppliHub allows users to manage their job application details through a secure and easy-to-use API. Users can submit their personal information, upload their CVs, and manage their application details as needed.

## Features

**User Details Management**

- Submit user details: Allow users to submit their last name, first name, date of birth, and email address.
- CV Upload: Users can upload their curriculum vitae.
- Review Details: Users can review their submitted details.
- Update Details: Users can update their submitted details.
- Delete Details: Users can delete their submitted details.

**File Handling**

- Upload and store CVs securely.

**RESTful API**

- Provides endpoints for creating, reading, updating, and deleting user details and CVs.

**Swagger (OpenAPI) Integration**

- API Documentation: Automatically generate API documentation using Swagger for easy API exploration and testing.

**Lombok Integration**

- Reduce Boilerplate Code: Improve code readability and maintainability by reducing boilerplate code with Lombok annotations.

## Technologies Used

- **Backend:** Java, Spring Boot
- **Database:** PostgreSQL
- **API Documentation:** Swagger (OpenAPI)
- **Simplified Java Development:** Lombok

## Prerequisites

Before you begin, ensure you have the following installed:

- Java Development Kit (JDK) 8 or higher
- Apache Maven
- PostgreSQL database
- IDE (IntelliJ IDEA, Eclipse, etc.)

## Setup Instructions

1. **Clone the repository:**

   ```bash
   git clone https://github.com/Deraclassic/AppliHub.git
   cd AppliHub

2. **Set up PostgreSQL database:**

    - Create a PostgreSQL database named `applihub_db`.
    - Update the `src/main/resources/application.properties` file with your PostgreSQL credentials.

   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/applihub_db
   spring.datasource.username=your_db_username
   spring.datasource.password=your_db_password
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true

3. **Build and run the application:**

    - Build the application using Maven:

      ```bash
      mvn clean install
      ```

    - Run the application:

      ```bash
      mvn spring-boot:run
      ```

## API Documentation

For API documentation and endpoints, refer to the Swagger UI available at:

- Local: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

### API Endpoints

#### Create a Job Application
- **URL:** `/api/applications`
- **Method:** `POST`
- **Request Body:**
  ```json
  {
    "lastName": "Doe",
    "firstName": "John",
    "dateOfBirth": "1990-01-01",
    "email": "john.doe@example.com"
  }

#### Request Part:
- `file`: CV file to upload (multipart/form-data)

#### Response:

```json
{
  "id": 1,
  "lastName": "Doe",
  "firstName": "John",
  "dateOfBirth": "1990-01-01",
  "email": "john.doe@example.com",
  "cvUrl": "http://localhost:8080/api/applications/1/cv"
}

```
4. **Access the application**

   The application will be accessible at `http://localhost:8080`.

5. **Run database migrations**

   Ensure that your database schema is up-to-date by running any necessary migrations. If you are using Flyway or Liquibase for migrations, this will typically be handled automatically on application startup. Verify your configuration in the `application.properties` file.

## API Documentation

Swagger UI is available at `http://localhost:8080/swagger-ui.html`.

## Usage

### User Registration and Login

- **Registration**
   - Endpoint: `POST /api/auth/register`
   - Request Body:
     ```json
     {
       "username": "exampleUser",
       "password": "examplePassword",
       "email": "user@example.com"
     }
     ```

- **Login**
   - Endpoint: `POST /api/auth/login`
   - Request Body:
     ```json
     {
       "username": "exampleUser",
       "password": "examplePassword"
     }
     ```

### Job Postings

- **View Job Application**
   - Endpoint: `POST /api/user/view`
   - Request Body:
     ```json
     {
       "title": "Software Engineer",
       "description": "Job description here",
       "requirements": "Job requirements here",
       "location": "Job location here",
       "salary": "Job salary here"
     }
     ```

- **Update Applicant Details**
   - Endpoint: `PUT /api/user/update`

- **Update Job Posting**
   - Endpoint: `PUT /api/jobs/{id}`
   - Request Body:
     ```json
     {
       "title": "Updated Job Title",
       "description": "Updated job description",
       "requirements": "Updated job requirements",
       "location": "Updated job location",
       "salary": "Updated job salary"
     }
     ```

- **Delete Application**
   - Endpoint: `DELETE /api/user/{id}`

### Applications

- **Submit Application**
   - Endpoint: `POST /api/applications`
   - Request Body:
     ```json
     {
       "jobId": 1,
       "applicantName": "John Doe",
       "resume": "Link to resume or resume text"
     }
     ```

## Contributing

Contributions are welcome! Please fork the repository and create a pull request with your changes.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Contact

For any inquiries or issues, please contact [your-email@example.com](mailto:your-email@example.com).
