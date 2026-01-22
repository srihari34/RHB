pipeline {
    agent any

    tools {
        jdk 'JDK17'
        maven 'Maven'
        allure 'Allure'  // Must be manually installed path in Jenkins Global Tool Config
    }

    triggers {
        pollSCM('H/2 * * * *')  // Poll every 2 minutes
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

            // Wrap in node {} to give FilePath context (required by Allure plugin)
            node {
                // Make sure your test results are in target/allure-results
                allure(
                    results: [[path: 'target/allure-results']],
                    includeProperties: false,
                    jdk: ''
                )
            }
        }
    }
}
