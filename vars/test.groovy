import com.scl.*

def call(){
    def pt = new PodTemplates("","").addKaniko().addGcloud()
    podTemplate(yaml: pt.toString()){
        node(POD_LABEL) {
            stage("Test"){
                container("kaniko") {
                    sh "kaniko --version"
                }

                container("gcloud") {
                    sh "gcloud --version"
                }
            }
        }
    }
}