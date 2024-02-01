pipeline {
    agent any

    stages {
        stage('Hello') {
            steps {
                echo 'Hello World'
            }
        }
    stage('checkout') {
            steps {
                git 'https://github.com/abhic137/hello-world-jenkins.git'
            }
        }
    stage('build') {
            steps {
                sh "mvn clean test"
            }
        }
    stage('test') {
            steps {
                sh "mvn install"
            }
        }
    stage('deploy') {
            steps {
                deploy adapters: [tomcat8(credentialsId: 'tomcat', path: '', url: 'http://192.168.138.130:8081/')], contextPath: null, war: '**/*.war'
            }
        }  
    }
    
}
