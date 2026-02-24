//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    println("Hello world.!")
    val numbers = intArrayOf(8, 5, 4, 15, 12, 7, 2)
    val target = 11

    println("--> Two sum indices: " + findTwoSum(target, numbers).contentToString())

}

fun findTwoSum(target: Int, numbers: IntArray): IntArray {
    val hashMap = mutableMapOf<Int, Int>()
    for (index in numbers.indices) {
        val difference = target - numbers[index]
        if(hashMap.containsKey(difference)) {
            return intArrayOf(hashMap[difference]!!, index)
        }
        println("Putting -> ${numbers[index]} at $index")
        hashMap[numbers[index]] = index
    }
    return intArrayOf()
}