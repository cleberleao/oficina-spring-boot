pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building e Deploy Java..'
                sshagent(credentials: ['150.230.88.104']) {
                    sh "ssh -o StrictHostKeyChecking=no -l opc 150.230.88.104 'cd ~/projeto && ./bash_script.sh'"
                }
            }
        }

        stage('Deploy') {
            steps {
               echo 'Deploy Mysql..'
               sshagent(credentials: ['150.230.88.104']) {
                    sh "ssh -o StrictHostKeyChecking=no -l opc 150.230.88.104 'cd ~/projeto && ./mysql_bash_script.sh'"
               }
            }
        }
    }
}