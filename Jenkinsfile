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

        stage('Build & Run Tests') {
            steps {
                bat 'mvn clean test'
            }
        }
    }

    post {
        always {
            echo 'Publishing Allure Report...'

            // Directly call allure plugin in declarative post
            allure(
                results: [[path: 'target/allure-results']],
                includeProperties: false
            )
        }
    }
}
