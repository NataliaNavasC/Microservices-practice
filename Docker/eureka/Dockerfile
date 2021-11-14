FROM adoptopenjdk/openjdk11:alpine-jre

EXPOSE 8761
EXPOSE 9990
EXPOSE 2220

VOLUME ["/web-apps"]

ADD eureka.jar .
#adds and runs the eureka server
ENTRYPOINT [ "java", "-jar", "eureka.jar" ]