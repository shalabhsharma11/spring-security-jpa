FROM openjdk:11.0.7-jre-slim-buster

RUN mkdir /app
COPY  target/spring-security-jpa*.jar /app/app.jar

WORKDIR /app

ENTRYPOINT ["java","-jar","/app/app.jar"]