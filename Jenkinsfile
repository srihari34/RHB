pipeline {
    agent any
    
    tools {
        jdk 'JDK17'
        maven 'Maven'
        allure 'Allure'  // This auto-installs if not present – good!
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
                // If tests fail → pipeline will still continue to next stages unless you add failure handling
            }
        }
        
        stage('Publish Allure Report') {
            steps {
                echo 'Publishing Allure Report...'
                allure(
                    includeProperties: false,
                    jdk: '',  // empty = use tool's JDK or system
                    results: [[path: 'target/allure-results']]
                )
            }
        }
    }
    
    post {
        always {
            echo 'Pipeline finished (post actions)'
            // Optional: archive other artifacts, email, etc.
            // archiveArtifacts artifacts: 'target/*.jar', allowEmptyArchive: true
        }
        success {
            echo 'Build succeeded!'
        }
        failure {
            echo 'Build failed – check console'
        }
    }
}