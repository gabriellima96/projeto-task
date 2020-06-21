FROM openjdk:14

WORKDIR /app

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

COPY src src

RUN chmod +x ./mvnw && ./mvnw dependency:go-offline -B && ./mvnw package -DskipTests

ENTRYPOINT ["java","-jar","/app/target/projeto-task-0.0.1-SNAPSHOT.jar"]