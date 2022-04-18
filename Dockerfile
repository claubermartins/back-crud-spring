FROM adoptopenjdk/openjdk11:alpine-jre
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} taxaSelic.jar
ENTRYPOINT ["java","-jar","taxaSelic.jar"]