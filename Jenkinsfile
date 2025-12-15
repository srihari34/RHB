pipeline {
    agent any

    tools {
        jdk 'JDK17'       // Name of the JDK you configured in Jenkins
        maven 'Maven'    // Name of Maven you configured in Jenkins
    }

    stages {
        stage('Checkout') {
            steps {
                // Pull code from GitHub
                git branch: 'main', url: 'https://github.com/srihari34/RHB.git'
            }
        }

        stage('Build & Run Test') {
            steps {
                // Run Maven tests
                bat 'mvn clean test'
            }
        }
}
  
}
