import com.scl.*

def call(){
    PodTemplate pt = new PodTemplate("big-cumulus-288805","dev").addKaniko()

    podTemplate(yaml: pt.toString()){
        stage("Test"){
            container("kaniko") {
                sh "echo haha"
            }
        }
    }
}