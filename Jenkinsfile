pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                 script {
                      sshagent(credentials: ['10']) {
                             sh 'ssh -o StrictHostKeyChecking=no -i /path/to/your/private_key.pem ec2-user@3.84.249.164 "sudo docker build -t oficina-spring ."'
                      }
                 }
            }
        }

        stage('Deploy') {
            steps {
                script {
                    sshagent(credentials: ['10']) {
                         sh 'ssh -o StrictHostKeyChecking=no -i /path/to/your/private_key.pem ec2-user@3.84.249.164 "sudo docker run -d -p 8081:8081 oficina-spring --name oficina-spring"'
                    }
                }
            }
        }
    }
}