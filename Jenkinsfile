  pipeline {
     agent any
     stages {
        stage('clean'){
          steps{
            sh 'rm -rf /users-deploy/*'
            sh 'rm -rf /client-services-deploy/*'
            sh 'rm -rf /tourism-services-deploy/*'
          }
        }
        stage('build gateway'){
          steps{
            dir('MicroServicios/GatewayService'){
                sh 'mvn package -Dmaven.test.skip'
                sh 'cp target/gateway.jar /eureka-deploy'
            }
          }
        }
        stage('build search') {
            steps{
              dir('MicroServicios/SearchService'){
                sh 'mvn package -Dmaven.test.skip'
                sh 'cp target/search.jar /eureka-deploy'
              }
            }
        }
        stage('build users') {  
          steps{
              dir('MicroServicios/UserService'){
                sh 'mvn package -Dmaven.test.skip'
                sh 'cp target/users.war /users-deploy'
              }
            }
        }
        stage('build providers') {
            steps{
              dir('MicroServicios/ProviderService'){
                sh 'mvn package -Dmaven.test.skip'
                sh 'cp target/providers.war /users-deploy'
              }
            }
        }
        stage('build tourists') {
            steps{
              dir('MicroServicios/TouristService'){
                sh 'mvn package -Dmaven.test.skip'
                sh 'cp target/tourists.war /users-deploy'
              }
            }
        }
        stage('build shopping') {
            steps{
              dir('MicroServicios/ShoppingService'){
                sh 'mvn package -Dmaven.test.skip'
                sh 'cp target/shopping.war /client-services-deploy'
              }
            }
        }
        stage('build questions') {
            steps{
              dir('MicroServicios/QuestionsService'){
                sh 'mvn package -Dmaven.test.skip'
                sh 'cp target/questions.war /client-services-deploy'
              }
            }
        }
        stage('build external') {
            steps{
              dir('MicroServicios/ExternalServices'){
                sh 'mvn package -Dmaven.test.skip'
                sh 'cp target/external.war /tourism-services-deploy'
              }
            }
        }
        stage('build toursim services') {
            steps{
              dir('MicroServicios/TourismServicesService'){
                sh 'mvn package -Dmaven.test.skip'
                sh 'cp target/tourism-services.war /tourism-services-deploy'
              }
            }
        }
        stage('build reviews') {
            steps{
              dir('MicroServicios/ReviewsService'){
                sh 'mvn package -Dmaven.test.skip'
                sh 'cp target/reviews.war /client-services-deploy'
              }
            }
        }
        stage('restart & deploy') {
            steps{
              sh 'docker restart eureka'
              sh 'docker exec eureka java -jar /web-apps/gateway.jar &'
              sh 'docker exec eureka java -jar /web-apps/search.jar &'
              sh 'docker restart users'
              sh 'docker restart tourism-services'
              sh 'docker restart client-services'
            }
        }
    }
}
