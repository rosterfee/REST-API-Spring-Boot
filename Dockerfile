FROM maven:3.5.2-jdk-8-alpine AS build
COPY pom.xml /tmp/
COPY api /tmp/api/
COPY impl /tmp/impl/
COPY web /tmp/web/
WORKDIR /tmp/
RUN mvn clean install -DskipTests=true

FROM openjdk:8-jdk-alpine
COPY --from=build /tmp/web/target/web-1.0.0.jar app.jar

RUN sh -c 'touch /app.jar'

ENTRYPOINT ["java","-jar","/app.jar"]