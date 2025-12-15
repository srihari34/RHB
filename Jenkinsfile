pipeline {
    agent any

    tools {
        jdk 'JDK17'       // Name of the JDK you configured in Jenkins
        maven 'Maven3'    // Name of Maven you configured in Jenkins
    }

    stages {
        stage('Checkout') {
            steps {
                // Pull code from GitHub
                git branch: 'main', url: 'https://github.com/srihari34/RHB.git'
            }
        }

        stage('Build & Test') {
            steps {
                // Run Maven tests
                sh 'mvn clean test'
            }
        }

        stage('Publish TestNG Results') {
            steps {
                // Publish TestNG report
                publishTestNGResults testResultsPattern: '**/target/surefire-reports/testng-results.xml'
            }
        }
    }
}
