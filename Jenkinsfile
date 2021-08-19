def projectName = 'cititrainingproject'
def version = "0.0.${currentBuild.number}"
def dockerImageTag = "${projectName}:${version}"

pipeline {
  agent any

  stages {
     stage('Build docker image') {
          // this stage also builds and tests the Java project using Maven
          steps {
            sh "docker build -t ${dockerImageTag} ."
          }
      }
    stage('Deploy Container To Openshift') {
      steps {
        sh "oc login --username=admin --password=admin"
        sh "oc project ${projectName} || oc new-project ${projectName}"
        sh "oc delete all --selector app=${projectName} || echo 'Unable to delete all previous openshift resources'"
        sh "oc new-app ${dockerImageTag} -l version=${version}"
        sh "oc expose svc/${projectName}"
      }
    }
  }
}
