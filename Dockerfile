FROM openjdk:8

ADD . /dpb_project
WORKDIR /dpb_project

RUN apt-get update && \
    apt-get install -y maven

RUN mvn clean package compile

# Run the spring boot application
ENTRYPOINT ["java", "-jar", "./target/dpb-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080
