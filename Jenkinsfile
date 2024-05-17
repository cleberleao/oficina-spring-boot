pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building e Deploy Java..'
                sshagent(credentials: ['146.235.34.143']) {
                    sh "ssh -o StrictHostKeyChecking=no -l opc 146.235.34.143 'cd ~/projeto && ./bash_script.sh'"
                }
            }
        }

        stage('Deploy') {
            steps {
               echo 'Deploy Mysql..'
               sshagent(credentials: ['146.235.34.143']) {
                    sh "ssh -o StrictHostKeyChecking=no -l opc 146.235.34.143 'cd ~/projeto && ./mysql_bash_script.sh'"
               }
            }
        }
    }
}
// pipeline {
//   agent any
//
//   stages {
//         stage('Build') {
//           steps {
//             echo 'Building e Deploy Java..'
//             sshagent(credentials: ['146.235.34.143']) {
//                 sh "ssh -o StrictHostKeyChecking=no -l opc 146.235.34.143 'cd ~/projeto && ./bash_script.sh'"
//             }
//          }
//          stage('Deploy') {
//            steps {
//              echo 'Deploy Mysql..'
//              sshagent(credentials: ['146.235.34.143']) {
//                  sh "ssh -o StrictHostKeyChecking=no -l opc 146.235.34.143 'cd ~/projeto && ./mysql_bash_script.sh'"
//             }
//          }
//       }
//    }
// }