# IncidentReportUsingSpringBoot
A RESTful API built with Java and Spring Boot for managing security incident reports, featuring CRUD operations, data validation, basic authentication, and logging. It uses an H2 in-memory database and includes unit tests for core functionality and security.
Overview
The Security Incident Management API is a RESTful service built with Java and Spring Boot that allows organizations to manage security incident reports efficiently. This API provides endpoints for creating, updating, listing, and retrieving incident reports, ensuring secure and reliable management of security-related incidents.

Features
Create Incident Reports: Submit new incident reports with details such as title, description, severity level, and incident date.
Update Incident Reports: Modify existing incident reports to update their status or add notes.
List Incidents: Retrieve a list of all incident reports with optional filtering by severity level and date range.
Retrieve Specific Incident: Fetch details of a specific incident report by its ID.
Data Validation: Ensure incidents adhere to business rules such as preventing reports with past dates greater than 30 days or future dates, validating severity levels, and ensuring unique and descriptive titles.
Database
In-Memory Database: Uses H2 in-memory database for storage and persistence of incident data.
Entity Model: Defines an Incident entity with fields for title, description, severity level, and incident date, along with a JPA repository for data access.
Security
Basic Authentication: The API is secured with basic authentication, using a hardcoded username and password for simplicity.
Logging: All API requests are logged to a file, including timestamp, IP address, endpoint accessed, and HTTP method.
Error Handling
Input Validation: Handles errors for invalid input, such as invalid dates or severity levels, and provides appropriate HTTP status codes for different scenarios.
Testing
Unit Tests: Includes unit tests for service methods using JUnit, ensuring basic functionality and correctness of the business logic.
Security Testing: Includes tests to validate security restrictions, ensuring that unauthenticated access is properly restricted.
Getting Started
To run the application locally:

Clone the Repository:
bash
Copy code
git clone https://github.com/your-username/security-incident-management-api.git
Navigate to the Project Directory:
bash
Copy code
cd security-incident-management-api
Build and Run the Application:
bash
Copy code
./mvnw spring-boot:run
Access the API: The application will run on http://localhost:8080. Use tools like Postman or curl to interact with the API endpoints.
API Endpoints
Create Incident: POST /api/incidents
Update Incident: PUT /api/incidents/{id}
List Incidents: GET /api/incidents
Retrieve Incident: GET /api/incidents/{id}
Sample Data
Sample data for the Incident entity is provided for initial testing and development purposes.

Contribution
Feel free to contribute to this project by submitting issues or pull requests. Contributions are welcome!

License
This project is licensed under the MIT License - see the LICENSE file for details.

