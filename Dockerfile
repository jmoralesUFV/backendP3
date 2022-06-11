FROM amazoncorretto:11-alpine-jdk
COPY target/restservice-V_2.1.jar applicacion.jar
ENTRYPOINT ["java","-jar","applicacion.jar"]
EXPOSE 8080
