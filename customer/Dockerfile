FROM maven:3-openjdk-17-slim AS build
RUN mkdir -p /workspace
WORKDIR /workspace
COPY pom.xml /workspace
COPY src /workspace/src
RUN mvn -f pom.xml clean package -DskipTests

FROM --platform=linux/amd64 openjdk:17-alpine
ARG JAR_FILE=/workspace/target/*.jar
COPY --from=build ${JAR_FILE} customer.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "customer.jar"]