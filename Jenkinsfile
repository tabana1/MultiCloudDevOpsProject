@Library('java-shared-library') _

pipeline {
    agent any
    // tools {
        // jdk 'jdk-17'
        // maven 'maven'
    // }

    environment {
        dockerHubCredentialsID = 'docker'
        imageName = 'tabana1/ivolve-grad'
        OPENSHIFT_SERVER = 'https://console-openshift-console.apps.ocp-training.ivolve-test.com'
        GIT_REPO = 'https://github.com/tabana1/MultiCloudDevOpsProject'
        OPENSHIFT_PROJECT = 'mohamedtabana'
        OPENSHIFT_CREDENTIALS_ID = 'open-shift-service'
      //  mysonar-token = 'sonarqube'
        SonarHostUrl = 'http://192.168.153.134:9000'
        SCANNER_HOME = tool 'sonar-qube'

    }
  

    stages {
        
        stage('Run Unit Test') {
            steps {
                script {
                    dir('my-app') {	
                	         runUnitTests()
                    }
        	}
    	    }
	    }


        // stage('Checkout') {
        //     steps {
        //         script {
        //             git branch: 'main', url: 'https://github.com/tabana1/MultiCloudDevOpsProject'
        //         }
        //     }
        // }
	    stage('SonarQube CD') {
            steps {
                script {                
                    dir('my-app') {
                                // sonarQubeCD(Token_Sonar)	
          withSonarQubeEnv('sonar-qube') { 
		    sh 'chmod +x gradlew'
            sh './gradlew sonar -Dsonar.java.binaries=build/classes'
	}
        //                            withCredentials([string(credentialsId: 'sonarqube', variable: 'SONAR_TOKEN')]) {
        //                 sh  """
        //                 	chmod +x gradlew

        //                     ./gradlew sonar \
        //                     -Dsonar.projectKey= "java-project" \
        //                     -Dsonar.host.url=${SonarHostUrl} \
        //                     -Dsonar.token=${SONAR_TOKEN} \
        //                     -Dsonar.scm.provider=git \
        //                     -Dsonar.java.binaries=build/classes
        //                     """
        //   }

                        }
            }
        }
        }
        stage('Build and Push Docker Image') {
            steps {
                script {
                    dir('my-app'){
                    dockerBuildAndPush(
                       dockerHubCredentialsID, imageName) }
                }
            }
        }
        stage('Deploy to OpenShift') {
            steps {
                script {
                    dir('openshift'){
                    openshiftDeploy(OPENSHIFT_CREDENTIALS_ID, imageName)
                    }
                }
            }
        }

    // post {
    //     always {
    //         echo 'Pipeline execution completed'
    //     }
    //     success {
    //         echo 'Pipeline executed successfully'
    //     }
    //     failure {
    //         echo 'Pipeline execution failed'
    //     }
    //     }
    }
}
