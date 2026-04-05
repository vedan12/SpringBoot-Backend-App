pipeline {
    agent any

    stages {
        stage('Checkout') {
        steps {
            git branch: 'main',
                url: 'https://github.com/vedan12/SpringBoot-Backend-App.git'
            }
        }

        stage('Build') {
        steps {
            withMaven(maven: 'Maven3') {
                    bat 'mvn clean compile'
                }
            }
        }

        stage('Test') {
        steps {
            withMaven(maven: 'Maven3') {
                    bat 'mvn test'
                }
            }
        }

        stage('Deploy') {
            steps {
                bat 'java -jar target\\*.jar'
            }
        }
    }
}
