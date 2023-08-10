import com.scl.*

def call(){
    def pt = new PodTemplates("","").addKaniko()

    podTemplate(yaml: pt.toString()){
        stage("Test"){
            container("kaniko") {
                sh "echo haha"
            }
        }
    }
}