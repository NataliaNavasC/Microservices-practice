FROM jenkins/jenkins:lts-jdk11

ENV JENKINS_USER=admin
ENV JENKINS_PASS=admin
ENV JAVA_OPTS=-Djenkins.install.runSetupWizard=false

USER root
ADD plugins.txt .
RUN jenkins-plugin-cli -f plugins.txt
ADD start.sh .
ENTRYPOINT [ "/start.sh" ]
