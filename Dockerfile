FROM openjdk:22
LABEL authors="gustavo_stinghen"

COPY target/gestaoprodutos-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]