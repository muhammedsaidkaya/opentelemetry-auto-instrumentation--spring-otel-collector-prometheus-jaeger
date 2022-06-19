FROM openjdk:18.0.1.1-oraclelinux7 as base
LABEL maintainer=muhammedsaidkaya

COPY opentelemetry-javaagent.jar lib/opentelemetry.jar
COPY target/print-service.jar lib/print-service.jar

EXPOSE 9091

ENTRYPOINT ["java","-javaagent:lib/opentelemetry.jar", "-jar","lib/print-service.jar"]
