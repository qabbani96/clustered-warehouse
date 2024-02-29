# Use the official OpenJDK base image
FROM maven:3.8.5-openjdk-17
COPY target/clustereddata-0.0.1.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]