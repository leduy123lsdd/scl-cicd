import com.scl.*

def call(){
    def pt = new PodTemplates("","").addKaniko()
    podTemplate(yaml: pt.toString()){
        node(POD_LABEL) {
            stage("Test"){
                container("kaniko") {
                    sh "echo haha"
                }
            }
        }
    }
}