FROM ubuntu:latest AS build

RUN apt-get update
RUN apt-get install openjdk-21-jdk -y
COPY . .

RUN apt-get install maven -y
RUN mvn clean install 

FROM openjdk:21-slim

EXPOSE 8080

COPY --from=build /target/pikababy_back.jar app.jar

ENTRYPOINT [ "java", "-jar", "app.jar" ]