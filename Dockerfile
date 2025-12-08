## Build stage
#FROM maven:3.9-eclipse-temurin-21 AS builder
#WORKDIR /app
#COPY pom.xml .
#COPY src ./src
#RUN mvn clean package -DskipTests
#
## Runtime stage - FIXED: Use eclipse-temurin instead of openjdk
#FROM eclipse-temurin:21-jdk
#WORKDIR /app
#COPY --from=builder /app/target/BK_Kindergarten_backend-0.0.1-SNAPSHOT.jar app.jar
#EXPOSE 8080
#ENTRYPOINT ["java", "-jar", "app.jar"]



# Build stage
FROM maven:3.9-eclipse-temurin-21 AS builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Runtime stage - Use JRE for smaller image
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Create non-root user for security
RUN addgroup -S spring && adduser -S spring -G spring

# Copy the built jar
COPY --from=builder /app/target/BK_Kindergarten_backend-0.0.1-SNAPSHOT.jar app.jar

# Set file permissions
RUN chown -R spring:spring /app
USER spring:spring

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]