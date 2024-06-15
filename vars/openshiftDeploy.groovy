def call(String OpenshiftcredintialsID, String imageName) {
    
    // Update deployment configuration with new Docker Hub image tag
    sh "sed -i 's|image:.*|image: ${imageName}|g' java-deployment-service.yaml"

    withKubeCredentials(kubectlCredentials: [[caCertificate: '', clusterName: '', contextName: '', credentialsId: 'token', namespace: 'my', serverUrl: 'https://api.ocp-training.ivolve-test.com:6443']]) {
        sh "oc apply -f java-deployment-service.yaml -n my-project"
    }
}