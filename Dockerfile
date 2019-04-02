FROM openjdk:latest
COPY ./target/seMethod.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "seMethod.jar"]