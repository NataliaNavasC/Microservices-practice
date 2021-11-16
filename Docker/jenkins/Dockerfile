FROM jenkins/jenkins:lts-jdk11

#skip wizard
ENV JENKINS_USER=admin
ENV JENKINS_PASS=admin
ENV JAVA_OPTS=-Djenkins.install.runSetupWizard=false

#install plugins
USER root
ADD plugins.txt .
RUN jenkins-plugin-cli -f plugins.txt

#install maven
RUN apt-get upgrade -y
RUN apt-get update
RUN apt-get install -y maven

# install docker
RUN apt-get update && apt-get install -y apt-transport-https \
       ca-certificates curl gnupg2 \
       software-properties-common
RUN curl -fsSL https://download.docker.com/linux/debian/gpg | apt-key add -
RUN apt-key fingerprint 0EBFCD88
RUN add-apt-repository \
       "deb [arch=amd64] https://download.docker.com/linux/debian \
       $(lsb_release -cs) stable"
RUN apt-get update && apt-get install -y docker-ce-cli

#run jenkins
ADD start.sh .
ENTRYPOINT [ "/start.sh" ]
