# Build

FROM maven:3.9-eclipse-temurin-25 AS builder

WORKDIR /app

# Copy files from maven
COPY .mvn/ .mvn
COPY mvnw pom.xml ./

# Download dependencies (this layer is cached)
RUN ./mvnw dependency:go-offline -B

# Copy source code
COPY src ./src

# Compile application (without tests for speed)
RUN ./mvnw clean package -DskipTests

# Runtime

FROM eclipse-temurin:25-jre-alpine
WORKDIR /app

# Create user no-root for security
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring

# Copy JAR from previous stage
COPY --from=builder /app/target/*.jar app.jar

# Expose port
EXPOSE 8080

# Default environment variables
ENV JAVA_OPTS="-Xmx512m -Xms256m"

# Start command
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]