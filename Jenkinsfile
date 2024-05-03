pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                 script {
                      sshagent(credentials: ['10']) {
                             sh 'ssh -o StrictHostKeyChecking=no -i /home/ec2-user/key/chave-server-docker.pem ec2-user@3.80.26.195 "sudo docker build -t oficina-spring ."'
                      }
                 }
            }
        }

        stage('Deploy') {
            steps {
                script {
                    sshagent(credentials: ['10']) {
                         sh 'ssh -o StrictHostKeyChecking=no -i /home/ec2-user/key/chave-server-docker.pem ec2-user@3.80.26.195 "sudo docker run -d -p 8080:8080 oficina-spring --name oficina-spring"'
                    }
                }
            }
        }
    }
}