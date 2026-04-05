pipeline {
    agent { label 'Jenkins-Worker-01' }

    triggers {
        githubPush()
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', 
                    credentialsId: 'github-creds', 
                    url: 'https://github.com/amarchavan-1/SpringBoot-Backend-App.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }
    }
}
