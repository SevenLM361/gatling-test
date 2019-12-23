// test gatling jenkins
pipeline {
    agent any
    stages {
        stage("Run Gatling") {
            steps {
                sh 'mvn clean gatling:test -Dgatling.simulationClass=com.research.RecordedSimulation'
            }
            post {
                always {
                    gatlingArchive()
                }
            }
        }
    }
}