import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

@OptIn(DelicateCoroutinesApi::class)
fun main() {
    runBlocking {

        val handler = CoroutineExceptionHandler { coroutineContext, throwable ->
            println("Exception handled: ${throwable.message}")
        }
        val job = GlobalScope.launch(Dispatchers.Default + handler) {
            println("--> Running coroutine...")
            throw IndexOutOfBoundsException("Exception in coroutine")
        }
        job.join()
    }

    runBlocking {
        val deferred = GlobalScope.async {
            println("Running async...")
            throw ArithmeticException("Exception in async")
        }

        try {
            deferred.await()
        } catch (e: ArithmeticException) {
            println(e.localizedMessage)
        }

    }
}