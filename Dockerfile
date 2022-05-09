FROM adoptopenjdk/openjdk11:alpine-jre
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} back-crud-spring.jar
ENTRYPOINT ["java","-jar","backCrudSpring.jar"]