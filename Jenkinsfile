// pipeline {
//     agent any
//
//     stages {
//         stage('Build') {
//             steps {
//                 sh 'podman build -t oficina-spring .'
//                 //
//             }
//         }
//
//         stage('Deploy') {
//             steps {
//                 sh 'podman run -d -p 8080:8080 oficina-spring --name oficina-spring'
//                 //
//             }
//         }
//     }
// }
pipeline {
  agent any

  stages {
        stage('Build') {
          steps {
            echo 'Building..'
            sshagent(['146.235.34.143']) {
                sh "ssh -o StrictHostKeyChecking=no -l opc 146.235.34.143 'cd /home/opc/projeto && ./bash_script.sh'"
            }
         }
      }
   }
}