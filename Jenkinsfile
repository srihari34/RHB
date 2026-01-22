pipeline {
    agent any
    
    tools {
        jdk 'JDK17'
        maven 'Maven'
    }
    
    triggers {
        pollSCM('H/2 * * * *')
    }
    
    stages {
        stage('Clean Workspace') {
            steps {
                deleteDir()
            }
        }
        
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/srihari34/RHB.git'
            }
        }
        
        stage('Build & Run Tests') {
            steps {
                bat 'mvn clean test'
            }
        }
    }
    
    post {
        always {
            echo 'Pipeline finished'
        }
        success {
            echo 'Build succeeded!'
        }
        failure {
            echo 'Build failed – check console'
        }
    }
}