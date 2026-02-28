import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        val mainJob = launch {
           println("main job started")

           val child1 = launch {
               println("child job 1 started")
               delay(2000)
           }

            val child2 = launch {
                println("child job 2 started")
                delay(1000)
            }

            child1.invokeOnCompletion {
                println("Completion of Child job 1")
            }

            child2.invokeOnCompletion {
                println("Completion of Child job 2")
            }
        }

        mainJob.invokeOnCompletion { println("main job completion **") }

        println("executing runBlocking delay")
        delay(1000)
        mainJob.cancel()
    }
}