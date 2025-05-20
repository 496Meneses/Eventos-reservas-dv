FROM ubuntu:latest as build
RUN apt-get update
RUN apt-get install maven openjdk-21-jdk -y
COPY .. /app
WORKDIR /app
RUN mvn clean package -DskipTests

FROM openjdk:21-jdk-slim
EXPOSE 8080
COPY --from=build /app/target/personal-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
