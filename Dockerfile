FROM openjdk:17.0.2

WORKDIR /app/usuarios-paqueteria

COPY ./usuarios-paqueteria/.mvn ./.mvn
COPY ./usuarios-paqueteria/mvnw .
COPY ./usuarios-paqueteria/pom.xml .

RUN ./mvnw clean package -Dmaven.test.skip -Dmaven.main.skip -Dspring-boot.repackage.skip && rm -r ./target

COPY ./usuarios-paqueteria/src ./src

RUN ./mvnw clean package -DskipTests

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "./target/usuarios-paqueteria-0.0.1-SNAPSHOT.jar"]