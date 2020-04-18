job('Astro Docker example') {
    scm {
        git('git://github.com/dinakarsvin/test-airflow.git') {  node -> // is hudson.plugins.git.GitSCM
            node / gitConfigName('DSL Astro User')
            node / gitConfigEmail('jenkins-dsl@dina.com')
        }
    }
    triggers {
        scm('H/5 * * * *')
    }
  
    steps {
        
		 shell("echo 'Initiating Build'")
		 
		 shell("docker login registry.gcp0001.us-east4.astronomer.io -u _ -p 60e33bcc6e96c093efe4d210b1d6f7b3")
		 
		 shell("echo ' Docker Build in progress '")
		 
		 shell("docker build -t registry.gcp0001.us-east4.astronomer.io/elementary-flyby-8509/airflow:ci-2 .")
		 
		 shell("docker push registry.gcp0001.us-east4.astronomer.io/elementary-flyby-8509/airflow:ci-2")
		 
		 shell("echo 'Build Completed'")
		
    }
}
