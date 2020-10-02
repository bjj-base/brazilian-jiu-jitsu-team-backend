FROM openjdk:11
MAINTAINER Evangelos Vatikiotis
ADD target/videos-0.0.1-SNAPSHOT.jar videos-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","videos-0.0.1-SNAPSHOT.jar"]
