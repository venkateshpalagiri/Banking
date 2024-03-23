FROM openjdk:17
LABEL maintainer="venkatesh.com"
ADD target/Banking-0.0.1-SNAPSHOT.jar banking-app.jar
ENTRYPOINT ["java","-jar","banking-app.jar"]


