FROM openjdk:21
EXPOSE 8080
ADD target/Hydromark.jar Hydromark.jar
ENTRYPOINT ["java", "-jar", "/Hydromark.jar"]
