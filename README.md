# Multi Cloud DevOps Project
![describe the project](https://private-user-images.githubusercontent.com/128842547/301504036-b727a8c9-1ef9-49e2-a6e8-d3cb812dd213.GIF?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3MTg0NDg2ODksIm5iZiI6MTcxODQ0ODM4OSwicGF0aCI6Ii8xMjg4NDI1NDcvMzAxNTA0MDM2LWI3MjdhOGM5LTFlZjktNDllMi1hNmU4LWQzY2I4MTJkZDIxMy5HSUY_WC1BbXotQWxnb3JpdGhtPUFXUzQtSE1BQy1TSEEyNTYmWC1BbXotQ3JlZGVudGlhbD1BS0lBVkNPRFlMU0E1M1BRSzRaQSUyRjIwMjQwNjE1JTJGdXMtZWFzdC0xJTJGczMlMkZhd3M0X3JlcXVlc3QmWC1BbXotRGF0ZT0yMDI0MDYxNVQxMDQ2MjlaJlgtQW16LUV4cGlyZXM9MzAwJlgtQW16LVNpZ25hdHVyZT1hMzIxZGYyMDY2ODMzNzM4ZDJjYmRiZjkyMTMyZDQ3OTJjZWM1YjVmNzkwNmM2ZTlmYmUzZjgwMDhmYTg0ZGIwJlgtQW16LVNpZ25lZEhlYWRlcnM9aG9zdCZhY3Rvcl9pZD0wJmtleV9pZD0wJnJlcG9faWQ9MCJ9.ymEBNaEHDBQL42IP0Uvp2YqPJl-sgSHWNKU_b1ubLZI)

This project demonstrates a complete CI/CD pipeline setup for a Java application using Terraform, Ansible, Jenkins, SonarQube, and OpenShift. The pipeline begins with infrastructure provisioning on AWS using Terraform, followed by configuration management and application deployment using Ansible, Jenkins, SonarQube and Deploy on OpenShift Cluster.

## Table of Contents

- [Prerequisites](#prerequisites)
- [Project Structure](#project-structure)
- [Terraform Setup](#terraform-setup)
- [Ansible Setup](#ansible-setup)
- [Jenkins](#jenkins)
- [Running the Pipeline](#running-the-pipeline)
- [Results](#results)


## Prerequisites

- AWS Account
- Terraform installed
- Ansible installed
- GitHub Account
- OpenShift Cluster
- DockerHub Account

## Project Structure
Certainly! Here's the structured representation of your project directory that includes descriptions and explanations for each directory and its contents:

```
│   Jenkinsfile                    # Jenkins pipeline file for automation.
│   README.md                      # Project documentation file.
│
├───ansible                        # Directory for Ansible configurations and playbooks.
│   │   ansible.cfg                # Ansible configuration file.
│   │   ansible_playbook.yml       # Main Ansible playbook.
│   │   aws_ec2.yml                # Ansible playbook for AWS EC2 instances.
│   │   Project.pem                # PEM file for AWS access.
│   │
│   ├───Jenkins                    # Ansible roles and configurations for Jenkins.
│   │   │   .travis.yml            # Travis CI configuration for Jenkins.
│   │   │   README.md              # Documentation for Jenkins setup.
│   │   │
│   │   ├───defaults               # Default variables for Jenkins setup.
│   │   │       main.yml
│   │   │
│   │   ├───files                  # Directory for Jenkins files.
│   │   │
│   │   ├───handlers               # Ansible handlers for Jenkins.
│   │   │       main.yml
│   │   │
│   │   ├───meta                   # Ansible metadata for Jenkins role.
│   │   │       main.yml
│   │   │
│   │   ├───tasks                  # Ansible tasks for Jenkins.
│   │   │       main.yml
│   │   │
│   │   ├───templates              # Directory for Jenkins templates.
│   │   │
│   │   ├───tests                  # Tests directory for Jenkins.
│   │   │       inventory          # Inventory file for testing Jenkins.
│   │   │       test.yml           # Test playbook for Jenkins.
│   │   │
│   │   └───vars                   # Ansible variables for Jenkins.
│   │           main.yml
│   │
│   ├───OpenShift                  # Ansible roles and configurations for OpenShift.
│   │   │   .travis.yml            # Travis CI configuration for OpenShift.
│   │   │   README.md              # Documentation for OpenShift setup.
│   │   │
│   │   ├───defaults               # Default variables for OpenShift setup.
│   │   │       main.yml
│   │   │
│   │   ├───files                  # Directory for OpenShift files.
│   │   │
│   │   ├───handlers               # Ansible handlers for OpenShift.
│   │   │       main.yml
│   │   │
│   │   ├───meta                   # Ansible metadata for OpenShift role.
│   │   │       main.yml
│   │   │
│   │   ├───tasks                  # Ansible tasks for OpenShift.
│   │   │       main.yml
│   │   │
│   │   ├───templates              # Directory for OpenShift templates.
│   │   │
│   │   ├───tests                  # Tests directory for OpenShift.
│   │   │       inventory          # Inventory file for testing OpenShift.
│   │   │       test.yml           # Test playbook for OpenShift.
│   │   │
│   │   └───vars                   # Ansible variables for OpenShift.
│   │           main.yml
│   │
│   ├───postgres                   # Ansible roles and configurations for PostgreSQL.
│   │   │   .travis.yml            # Travis CI configuration for PostgreSQL.
│   │   │   README.md              # Documentation for PostgreSQL setup.
│   │   │
│   │   ├───defaults               # Default variables for PostgreSQL setup.
│   │   │       main.yml
│   │   │
│   │   ├───files                  # Directory for PostgreSQL files.
│   │   │
│   │   ├───handlers               # Ansible handlers for PostgreSQL.
│   │   │       main.yml
│   │   │
│   │   ├───meta                   # Ansible metadata for PostgreSQL role.
│   │   │       main.yml
│   │   │
│   │   ├───tasks                  # Ansible tasks for PostgreSQL.
│   │   │       main.yml
│   │   │
│   │   ├───templates              # Directory for PostgreSQL templates.
│   │   │
│   │   ├───tests                  # Tests directory for PostgreSQL.
│   │   │       inventory          # Inventory file for testing PostgreSQL.
│   │   │       test.yml           # Test playbook for PostgreSQL.
│   │   │
│   │   └───vars                   # Ansible variables for PostgreSQL.
│   │           main.yml
│   │
│   ├───prerequisite               # Ansible roles and configurations for prerequisites.
│   │   │   .travis.yml            # Travis CI configuration for prerequisites.
│   │   │   README.md              # Documentation for prerequisites setup.
│   │   │
│   │   ├───defaults               # Default variables for prerequisites setup.
│   │   │       main.yml
│   │   │
│   │   ├───files                  # Directory for prerequisite files.
│   │   │
│   │   ├───handlers               # Ansible handlers for prerequisites.
│   │   │       main.yml
│   │   │
│   │   ├───meta                   # Ansible metadata for prerequisites role.
│   │   │       main.yml
│   │   │
│   │   ├───tasks                  # Ansible tasks for prerequisites.
│   │   │       main.yml
│   │   │
│   │   ├───templates              # Directory for prerequisite templates.
│   │   │
│   │   ├───tests                  # Tests directory for prerequisites.
│   │   │       inventory          # Inventory file for testing prerequisites.
│   │   │       test.yml           # Test playbook for prerequisites.
│   │   │
│   │   └───vars                   # Ansible variables for prerequisites.
│   │           main.yml
│   │
│   └───sonarqube                  # Ansible roles and configurations for SonarQube.
│       │   .travis.yml            # Travis CI configuration for SonarQube.
│       │   README.md              # Documentation for SonarQube setup.
│       │
│       ├───defaults               # Default variables for SonarQube setup.
│       │       main.yml
│       │
│       ├───files                  # Directory for SonarQube files.
│       │       sonarqube.service  # Systemd service file for SonarQube.
│       │
│       ├───handlers               # Ansible handlers for SonarQube.
│       │       main.yml
│       │
│       ├───meta                   # Ansible metadata for SonarQube role.
│       │       main.yml
│       │
│       ├───tasks                  # Ansible tasks for SonarQube.
│       │       main.yml
│       │
│       ├───templates              # Directory for SonarQube templates.
│       │
│       ├───tests                  # Tests directory for SonarQube.
│       │       inventory          # Inventory file for testing SonarQube.
│       │       test.yml           # Test playbook for SonarQube.
│       │
│       └───vars                   # Ansible variables for SonarQube.
│               main.yml
│
├───my-app                          # Project-specific files and configurations.
│   │   .DS_Store                    # macOS system file, can be ignored.
│   │   build.gradle                 # Gradle build file for the project.
│   │   Dockerfile                   # Docker configuration file.
│   │   gradlew                      # Gradle wrapper script for Unix-based systems.
│   │   gradlew.bat                  # Gradle wrapper script for Windows.
│   │   settings.gradle              # Gradle settings file for the project.
│   │
│   ├───gradle                       # Gradle wrapper directory.
│   │   └───wrapper
│   │           gradle-wrapper.jar   # Gradle wrapper JAR.
│   │           gradle-wrapper.properties  # Gradle wrapper properties file.
│   │
│   └───src                          # Source directory for the project.
│       └───main
│           ├───java                 # Java source directory.
│           │   └───com/example/demo # Package structure for Java classes.
│           │       └───controller   # Controller classes.
│           │               HomeController.java  # Example controller.
│           │
│           └───resources            # Resource directory.
│               │   application.properties  # Application properties file.
│               │
│               └───templates        # Templates directory.
│                       index.html   # Example HTML template file.
│
├───openshift                       # OpenShift deployment configuration files.
│       deployment.yaml              # Deployment configuration for OpenShift.
│       route.yaml                   # Route configuration for OpenShift.
│       service.yaml                 # Service configuration for OpenShift.
```

## Terraform Setup
1. **Clone the Repository:**

    ```
    git clone <repository-url>
    cd <repository-directory>/terraform

    ```
2. **Configure Variables:**

    Edit the terraform.tfvars file to set values for your AWS setup.

3. **Initialize Terraform:**

    ```
    terraform init

    ```

4. **Review the Plan:**

    ```
     terraform plan

    ```

5. **Apply the Configuration:**

    ```
    terraform apply
    ```

    Confirm the action by typing yes when prompted.

    ![](https://github.com/tabana1/MultiCloudDevOpsProject/blob/74daa142881a6c3d4ffeb77676ea68cb27dfbac5/screenshot/Terraform%20Enviroment%20Created.png)


## Review the Created Enviroment
6. **AWS Resources Created:**

    - EC2 Instances

        ![](https://github.com/tabana1/MultiCloudDevOpsProject/blob/main/screenshot/Instance%20created.png)


    - CloudWatch with SNS topic for email notifications

        ![](https://github.com/tabana1/MultiCloudDevOpsProject/blob/main/screenshot/SNS.png)
        ![](https://github.com/tabana1/MultiCloudDevOpsProject/blob/main/screenshot/aws%20notfication.png)
        ![](https://github.com/tabana1/MultiCloudDevOpsProject/blob/main/screenshot/alarm.png)

    - S3 Bucket for Terraform state file backend

        ![](https://github.com/tabana1/MultiCloudDevOpsProject/blob/main/screenshot/Backet.png)

## Ansible Setup

1. **Navigate to Ansible Directory:**
    ```
    cd ../Ansible

    ```
2. **Install Jenkins, SonarQube, Docker, and OC CLI:**

    Use Ansible roles to install the necessary services.

3. **Dynamic Inventory:**

    Use the aws_ec2 plugin for dynamic inventory.

4. **Generate Private Key:**

    Terraform will generate private_key.pem and add it to the Ansible folder.

5. **Run Ansible Playbook:**

    ```
    ansible-playbook -i aws_ec2.yml playbook.yml

    ```

    ![](https://github.com/tabana1/MultiCloudDevOpsProject/blob/main/screenshot/ansible%20run.png)

## Jenkins 

1. **Pipeline Configration:**

    - Choose SCM and add repository URL and branch name.

    ![](https://github.com/tabana1/MultiCloudDevOpsProject/blob/main/screenshot/pipeline%20configration.png)

## Running the Pipeline

1. **Run Pipeline:**
    Execute the pipeline from Jenkins.


2. **Monitor Pipeline:**

    Ensure the pipeline runs successfully.

![](https://github.com/tabana1/MultiCloudDevOpsProject/blob/main/screenshot/Jenkins%20run.png)


## Results

1. **SonarQube :**

    Review code quality reports on SonarQube.

![](https://github.com/tabana1/MultiCloudDevOpsProject/blob/main/screenshot/sonarqube%20.png)

2. **Application Deployment:**

    Verify your application is running on the OpenShift cluster.

    Login In Your Cluster and Run 

    ```
    oc get all -n namespace

    ```

    ![](https://github.com/tabana1/MultiCloudDevOpsProject/blob/main/screenshot/final%20result.png)


