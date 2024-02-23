FROM openjdk:8
EXPOSE 8084
ADD target/petClinic-0.0.1-SNAPSHOT.war petClinic-0.0.1-SNAPSHOT.war
ENTRYPOINT [ "java","-jar","/petClinic-0.0.1-SNAPSHOT.war" ]
