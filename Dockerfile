FROM openjdk:8-jdk-alpine
# VOLUME /tmp
# ARG JAR_FILE
# ADD ${JAR_FILE} app.jar
ADD serviceha-app/target/serviceha-app-0.0.1-SNAPSHOT.jar app.jar
# ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
ENTRYPOINT ["java", "-jar","app.jar"]

EXPOSE 8443