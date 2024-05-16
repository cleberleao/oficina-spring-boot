pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                sh 'podman build -t oficina-spring .'
                //
            }
        }

        stage('Deploy') {
            steps {
                sh 'podman run -d -p 8080:8080 oficina-spring --name oficina-spring'
                //
            }
        }
    }
}