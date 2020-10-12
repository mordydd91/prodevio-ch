FROM openjdk:8-jdk-alpine
ENV server.address=0.0.0.0
EXPOSE 5000
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
