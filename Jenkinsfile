pipeline {
    agent any

    stages {
    
        stage('Making Infrastrucuture up') {
            steps {
                sh "sudo docker-compose up -d hub chrome firefox"
            }
        }
        
         stage('Running Test Cases') {
            steps {
                sh "sudo mvn -Dmaven.test.failure.ignore=true test"
            }
        
            post {
            always {

            emailext attachLog: true, attachmentsPattern: 'Chrometestreports/cucumber-reports/reports.html', body: '''Hey Team,
<p>Here is the details of Execution through Jenkins<br>

$PROJECT_NAME - Build # $BUILD_NUMBER - $BUILD_STATUS:<br>

Check console output at $BUILD_URL to view the results.<br>

Thanks,<br>
Automation Team - ATT 19-August <h3>(Himanshu)</h3>''', subject: '$PROJECT_NAME - Build # $BUILD_NUMBER - $BUILD_STATUS! - Execution of Maven project on Google Chrome Browser', to: 'himanshudalal76247@gmail.com'
        	}
   		 }
   		 
   		}
   	 
   	 	
   	 	stage('Making Infrastructure down') {
            steps {
                sh "sudo docker-compose down"	
            }
        }
   	 
       }
  }


