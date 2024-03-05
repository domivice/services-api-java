# Use a base image with JDK 21 from AdoptOpenJDK
FROM eclipse-temurin:21.0.2_13-jdk-jammy AS builder

# Set the working directory
WORKDIR /app

# Copy Maven wrapper files and the main project POM
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Copy all modules
COPY services.application services.application
COPY services.domain services.domain
COPY services.infrastructure services.infrastructure
COPY services.web services.web

# Build the application
RUN ./mvnw clean install -DskipTests

# Second stage: create a minimal runtime image
FROM eclipse-temurin:21.0.2_13-jre-jammy

# Set the working directory
WORKDIR /app

# Copy the built JAR file from the builder stage
COPY --from=builder /app/services.web/target/services-web-0.0.1-SNAPSHOT.jar .

# Copy the certificate files into the /certificates folder
COPY services.web/src/main/resources/certs/*.crt /certificates/

# Expose the port that the application will run on
EXPOSE 8080

# Start the application
CMD ["java", "-jar", "services-web-0.0.1-SNAPSHOT.jar"]