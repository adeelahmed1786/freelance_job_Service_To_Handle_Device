FROM java:8
EXPOSE 8083
ADD /target/device-1-SNAPSHOT.jar dockerdemo.jar
ENTRYPOINT ["java", "-jar", "dockerdemo.jar"]