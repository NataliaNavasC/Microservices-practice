FROM adoptopenjdk/openjdk11:alpine-jre

EXPOSE 8761

VOLUME ["/tmp"]

ADD eureka.jar .

ENTRYPOINT [ "java", "-jar", "eureka.jar" ]