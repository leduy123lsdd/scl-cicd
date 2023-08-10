import com.scl.*

def call(){
    def pt = new PodTemplate()

    podTemplate(yaml: pt.test()){
        stage("Test"){
            container("kaniko") {
                sh "echo haha"
            }
        }
    }
}