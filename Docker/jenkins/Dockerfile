FROM jenkins/jenkins:lts-jdk11

ENV JENKINS_USER=admin
ENV JENKINS_PASS=admin
ENV JAVA_OPTS=-Djenkins.install.runSetupWizard=false

USER root
RUN apt-get upgrade -y
RUN apt-get update
RUN apt-get install -y maven


ADD plugins.txt .
RUN jenkins-plugin-cli -f plugins.txt
ADD start.sh .
ENTRYPOINT [ "/start.sh" ]
