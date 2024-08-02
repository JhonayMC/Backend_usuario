FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/serv-repo-0.0.1.jar
COPY ${JAR_FILE} app_usuarios.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app_usuarios.jar"]

