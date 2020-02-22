pipeline{
    agent any
    // tools{
    //     maven 'mvn-3.5.4'
    // }
    stages{
        stage('Build'){
            steps{
                echo 'Hello world'
                // sh "mvn clean package"
                sh "printenv"
            }
            post{
                changed{
                    echo "pipeline post changes"
                }
                always{
                    echo "stage post alwasy"
                }
            }
        }
        stage('Test'){
            steps{
                echo 'Test Hello world'
                // sh "mvn clean package"
                sh "printenv"
            }
            post{
                changed{
                    echo "pipeline post changes"
                }
                always{
                    echo "stage post alwasy"
                }
            }
        }
    }
    post{
        always{
            echo "pileline always....ddd"
        }
    }
}
