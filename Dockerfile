FROM openjdk:17-jdk-alpine as builder

WORKDIR /app/usuarios-paqueteria

COPY ./.mvn ./.mvn
COPY ./mvnw .
COPY ./pom.xml .

RUN ./mvnw clean package -Dmaven.test.skip -Dmaven.main.skip -Dspring-boot.repackage.skip && rm -r ./target/

COPY ./src ./src

RUN ./mvnw clean package

FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY --from=builder /app/usuarios-paqueteria/target/usuarios-paqueteria-0.0.1-SNAPSHOT.jar .

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "usuarios-paqueteria-0.0.1-SNAPSHOT.jar"]