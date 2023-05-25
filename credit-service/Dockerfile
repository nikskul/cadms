FROM maven:3.9.2-eclipse-temurin-17-alpine AS build
WORKDIR /app
COPY pom.xml .
COPY src /app/src
RUN mvn -f pom.xml clean install -DskipTests=true

FROM openjdk:17-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8100
CMD ["java","-jar","app.jar"]
