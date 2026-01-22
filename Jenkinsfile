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
            node {
                echo 'Publishing Allure Report...'
                allure results: [[path: 'allure-results']], includeProperties: false, jdk: '', allowEmptyResults: true
            }
        }
    }
}
