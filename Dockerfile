# Stage 1: Build the application using Maven
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

# Copy pom.xml and source code
COPY pom.xml .
COPY src ./src

# Compile and package the application into a jar file
RUN mvn clean package -DskipTests

# Stage 2: Run the application using a standard JRE (Debian-based to avoid SSL issues with MongoDB Atlas)
FROM eclipse-temurin:17-jre
WORKDIR /app

# Copy the built jar from Stage 1
COPY --from=build /app/target/backend-0.0.1-SNAPSHOT.jar app.jar

# Render injects the PORT environment variable dynamically
ENV PORT=8080
EXPOSE 8080

# Run the jar file, mapping server.port to the Render PORT environment variable
ENTRYPOINT ["java", "-jar", "app.jar", "--server.port=${PORT}"]
