#FROM ubuntu:latest
#LABEL authors="jannohany"
#
#ENTRYPOINT ["top", "-b"]


FROM gradle:8.10.2-jdk17 AS build
WORKDIR /app

COPY build.gradle settings.gradle gradlew ./
COPY gradle gradle
COPY src src

RUN chmod +x gradlew
RUN ./gradlew bootJar --no-daemon

FROM eclipse-temurin:17-jre
WORKDIR /app

COPY --from=build /app/build/libs/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/app.jar", "--spring.profiles.active=docker"]