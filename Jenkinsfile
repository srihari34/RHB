pipeline {
    agent any

    tools {
        jdk 'JDK17'
        maven 'Maven'
        allure 'Allure'
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

        stage('Build & Run Test') {
            steps {
                bat 'mvn clean test'
            }
        }
    }

    post {
        always {
            echo 'Publishing Allure Report...'

            // ✅ Use script block to provide workspace context
            script {
                allure results: [[path: 'allure-results']], includeProperties: false, jdk: ''
            }
        }
    }
}
