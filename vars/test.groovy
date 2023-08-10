import com.scl.*

def call(){
    def pt = new PodTemplates()

    podTemplate(yaml: pt.test()){
        stage("Test"){
            container("kaniko") {
                sh "echo haha"
            }
        }
    }
}