FROM openjdk:8
#VOLUME /tmp
ADD target/studentenrollment-0.0.1-SNAPSHOT.jar studentenrollment-0.0.1-SNAPSHOT.jar
EXPOSE 9595
ENTRYPOINT ["java", "-jar" , "studentenrollment-0.0.1-SNAPSHOT.jar"]