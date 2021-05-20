FROM openjdk:15
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} flats-0.0.1.jar
ENTRYPOINT ["java","-jar","/flats-0.0.1.jar"]