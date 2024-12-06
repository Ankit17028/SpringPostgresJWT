# 🛡️ Role-Based Access Control (RBAC) Application

The **RBAC Application** is a full-stack application that implements **Authentication**, **Authorization**, and **Role-Based Access Control (RBAC) using Java, Spring Boot, PostgreSQL, and React.js**. This application ensures secure user authentication and authorizes user actions based on their assigned roles.

--

## 🛠️ Technologies Used

- **Frontend**: React.js
- **Backend**: Java, Spring Boot
- **Database**: PostgreSQL
- **Authentication**: JWT (JSON Web Tokens)
- **ORM**: Hibernate with JPA
- **Containerization**: Docker


## ✅ Prerequisites

- **Node.js**: Required for running the frontend.
- **Java 17+**: Ensure Java is installed by running:

```bash
java -version
```
Maven: Ensure Maven is installed by running:

```bash
mvn -version
```

- **PostgreSQL Database**: Set up with user credentials for database access.

- **PostgreSQL Driver**: Make sure to include the PostgreSQL driver in your dependencies.




## 🚀 Features
**User Authentication**: Secure user registration, login, and logout mechanisms.

**Role-Based Authorization**: Assign roles (Admin, User, Moderator) and manage access to resources based on roles.

**Secure Sessions**: Manage user sessions using JWT.

**Database Integration**: Utilize PostgreSQL for storing user data and roles.

**CORS Configuration**: Allow specific origins to interact with the backend securely.



## 📁 Project Structure
**Backend (Spring Boot with PostgreSQL)**
- The Spring Boot application handles authentication, authorization, and RBAC logic. Configured with PostgreSQL for persistent data storage, the backend runs on port 8080.

Endpoints:
/register (POST): Registers a new user.

/login (POST): Authenticates a user and returns a JWT.

/roles (GET): Retrieves all roles (Admin access).

/users (GET): Retrieves all users (Admin access).

## Frontend (React.js)
The frontend, running on port 3000, provides a user-friendly interface for user registration, login, and managing roles.


## 🛠️ Setup Instructions for RBAC Application
**Prerequisites**
**Java 17+**: Ensure Java is installed by running:

```bash
java -version
```

Maven: Ensure Maven is installed by running:

```bash
mvn -version
```

**PostgreSQL**: Set up a PostgreSQL database and create a schema for the application. Configure the backend to use this database by updating application.properties.
**Node.js**: Verify Node.jsinstallation for running the React frontend:

```bash
node -v
```
```bash
npm -v
```

## Steps
1. **Clone the Repository**

```bash
git clone https://github.com/Ankit17028/SpringPostgresJWT.git
cd backend
```

2. **Backend Setup (In IntelliJ IDEA)**

- Configure Database in application.properties: Open src/main/resources/application.properties and set PostgreSQL credentials:

properties
```bash
spring.datasource.url=jdbc:postgresql://localhost:3306/Database-Name
spring.datasource.username=Your-username
spring.datasource.password=Your-password
spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.hibernate.ddl-auto=update
```

Open Backend in IntelliJ IDEA: Open IntelliJ IDEA, select File > Open, and navigate to the RBAC-Application/backend folder. Wait for IntelliJ to load dependencies.

Build and Run the Backend: Run the following commands in the terminal to build and run the application:

```bash
./mvnw clean install
```
After installing Maven, run the application:

```bash
./mvnw spring-boot:run
```

**Run the backend application by selecting the Application class and choosing Run. The backend server should be accessible at http://localhost:8080.**

3. **Frontend Setup (In Visual Studio Code)**

- Open Frontend in Visual Studio Code: Navigate to the frontend directory (e.g., RBAC-Application/frontend). Open it in VS Code by running:

```bash
cd frontend
```

Install Dependencies:
```bash
npm install
```

Run the Frontend Application:

```bash
npm run start
```

- The frontend server should be accessible at http://localhost:3000.

# 🌐 Access the Application
Once both backend and frontend are running:

Frontend: Visit http://localhost:3000 to access the web UI.
Backend API: The backend API is available at http://localhost:8080.
