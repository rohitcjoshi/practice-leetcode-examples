import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.random.Random

fun main() {
    runBlocking {
        val first = async { getFirstValue() }
        val second = async { getSecondValue() }

        println("Doing some processing...")

        delay(500)

        println("Waiting for values....")

        val firstValue = first.await()
        val secondValue = second.await()
        println("Value 1: $firstValue + Value2: $secondValue = ${firstValue + secondValue}")
    }
}

suspend fun getFirstValue(): Int {
    delay(1500)
    val value = Random.nextInt(100)
    println("1st Value: ${value}")

    return value
}

suspend fun getSecondValue(): Int {
    delay(2000)
    val value = Random.nextInt(101, 200)
    println("2nd Value: ${value}")
    return value
}