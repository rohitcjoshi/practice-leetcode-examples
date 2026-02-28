import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
@OptIn(DelicateCoroutinesApi::class)
fun main() {
    println("Learning scope")

    println("Learning coroutine scopes")

    runBlocking {
        launch {
            delay(1000)
            println("Executing runBlocking scope")
        }

        GlobalScope.launch {
            delay(500)
            println("Executing GlobalScope scope")
        }

        coroutineScope {
            delay(1500)
            println("Executing coroutineScope scope")
        }
    }
    println("Outside runBlocking")

}