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
                sh '''
                    scp -o StrictHostKeyChecking=no bash_script.sh opc@146.235.34.143:/home/opc/projeto
                    ssh -o StrictHostKeyChecking=no -l opc 146.235.34.143 'bash /home/opc/projeto/bash_script.sh'
                '''
            }
         }
      }
   }
}