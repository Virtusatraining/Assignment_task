pipeline{
agent any
stages {
         stage('Clone sources') {
             steps{
        git branch: 'main', url: 'https://github.com/Virtusatraining/Assignment_task.git'
    }
         }
        stage ('war file creation') 
        {
            steps{
                sh ("jar -cvf index.war *")
            }
        }
        stage (deploy_tomcat)
        {
            steps{
            deploy adapters: [tomcat9(credentialsId: 'a5399b38-989b-44a0-bf88-6f1be760600b', path: '', url: 'http://localhost:8081/')], contextPath: 'test', war: '**/*.war'
        }
        }
}
}
