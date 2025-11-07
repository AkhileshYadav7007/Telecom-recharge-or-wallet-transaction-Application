# RechargeServices

This project provides a robust and scalable backend for various recharge services, built using Spring Boot. It's designed to handle mobile recharges, bill payments, and other related transactions securely and efficiently.

## Technologies Used

*   **Java 21**: The core programming language.
*   **Spring Boot 3.3.3**: Framework for building stand-alone, production-grade Spring applications.
*   **Spring Security**: For authentication and authorization, including JWT.
*   **Spring Data JPA**: For data access and persistence with relational databases.
*   **MySQL**: The relational database used for storing application data.
*   **Lombok**: A library that helps reduce boilerplate code.
*   **JWT (JSON Web Tokens)**: For secure API authentication.
*   **Swagger/OpenAPI**: For interactive API documentation and testing.

## Features

*   User authentication and authorization using JWT.
*   Secure API endpoints for various recharge operations.
*   Database persistence for user and transaction data.
*   Clear and interactive API documentation.
*   Scalable architecture for handling multiple recharge types.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

Ensure you have the following installed on your system:

*   **Java Development Kit (JDK) 21** or higher
*   **Apache Maven**
*   **MySQL Server**

### Installation

1.  **Clone the repository:**
    ```sh
    git clone https://github.com/your-username/RechargeServices.git
    cd RechargeServices
    ```
2.  **Configure the database:**
    Create a MySQL database (e.g., `recharge_db`).
    Update the database connection properties in `src/main/resources/application.properties` with your MySQL credentials:
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/your-database-name?useSSL=false&serverTimezone=UTC
    spring.datasource.username=your-username
    spring.datasource.password=your-password
    spring.jpa.hibernate.ddl-auto=update # Or create, depending on your preference
    spring.jpa.show-sql=true
    ```
    *Note: `spring.jpa.hibernate.ddl-auto=update` will automatically create/update tables based on your JPA entities. For production, consider `validate` or `none` and use migrations.*

3.  **Build the project:**
    ```sh
    mvn clean install
    ```

### Running the Application

Once the project is built, you can run the Spring Boot application:

```sh
mvn spring-boot:run
```
The application will start on `http://localhost:8080`.

## API Documentation

The API documentation is generated using Swagger UI. Once the application is running, you can access the interactive documentation at:

http://localhost:8081/swagger-ui.html

## Contributing

Contributions are what make the open-source community such an amazing place to learn, inspire, and create. Any contributions you make are **greatly appreciated**.

1.  Fork the Project
2.  Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3.  Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4.  Push to the Branch (`git push origin feature/AmazingFeature`)
5.  Open a Pull Request

## License

Distributed under the MIT License. See `LICENSE` for more information.

## Contact

Akhilesh Yadav - Email id: akhileshyadavji7007@gmail.com
