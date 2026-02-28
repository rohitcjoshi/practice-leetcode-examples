import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        // This can not be launched from normal kotlin -- need android dependency
//        launch(Dispatchers.Main) {
//            println("Main dispatcher: ${Thread.currentThread().name}")
//        }

        launch(Dispatchers.Default) {
            println("Default dispatcher: ${Thread.currentThread().name}")
        }

        launch(Dispatchers.Unconfined) {
            println("Unconfined dispatcher1: ${Thread.currentThread().name}")
            delay(100)
            println("Unconfined dispatcher2: ${Thread.currentThread().name}")
        }

        launch(Dispatchers.IO) {
            println("IO dispatcher2: ${Thread.currentThread().name}")
            delay(150)
            println("IO dispatcher2: ${Thread.currentThread().name}")
        }
    }
}