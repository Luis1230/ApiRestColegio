FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY target/ApiRestColegio-0.0.1-SNAPSHOT.jar .

EXPOSE 8081

ENTRYPOINT [ "java", "-jar", "ApiRestColegio-0.0.1-SNAPSHOT.jar" ]
