FROM adoptopenjdk/openjdk11:alpine-jre

EXPOSE 8761
EXPOSE 9990

VOLUME ["/web-apps"]

ADD eureka.jar .

ENTRYPOINT [ "java", "-jar", "eureka.jar" ]