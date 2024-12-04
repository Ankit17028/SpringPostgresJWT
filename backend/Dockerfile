# Use the official Maven image to build the application
FROM maven:3.8.4-openjdk-17 AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the pom.xml file to the container
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy the source code to the container
COPY src ./src

# Package the application using Maven
RUN mvn clean package -DskipTests

# Use the official OpenJDK image to run the application
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the packaged JAR file from the build stage
COPY --from=build /app/target/backend-1.0-SNAPSHOT.jar app.jar

# Expose the port the application runs on
EXPOSE 8080

# Set environment variables
ENV DB_DRIVER_CLASS_NAME=org.postgresql.Driver
ENV DB_INITIALIZATION_MODE=always
ENV DB_PASSWORD=12345678
ENV DB_PLATFORM=postgres
ENV DB_URL=jdbc:postgresql://localhost:5432/secureDB5
ENV DB_USERNAME=postgres
ENV JPA_DATABASE_PLATFORM=org.hibernate.dialect.PostgreSQLDialect
ENV JPA_HIBERNATE_DDL_AUTO=create
ENV JPA_SHOW_SQL=false
ENV JWT_SECRET_KEY=my-secret-key
ENV CORS_ALLOWED_ORIGIN=http://localhost:3000

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
