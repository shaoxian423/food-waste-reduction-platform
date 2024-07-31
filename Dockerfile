FROM openjdk:11-jdk-slim
VOLUME /tmp
COPY target/Final-Project1-1.0-SNAPSHOT.jar food-waste-reduction-platform.jar
ENTRYPOINT ["java","-jar","/food-waste-reduction-platform.jar"]
