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
		stage('Generate Allure Report') {
            steps {
                // Generate Allure report as static HTML in target/site
                bat 'mvn allure:report'
            }
        }
        
        stage('Publish Allure Report') {
            steps {
                // Use Jenkins Allure plugin to publish report
                allure([
                    includeProperties: false,
                    jdk: 'JDK17', // Optional: matches your JDK tool
                    results: [[path: 'target/allure-results']]
                ])
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