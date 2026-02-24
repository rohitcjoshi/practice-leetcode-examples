fun main() {
    println("-> Array concatenation <-")
//    Given an integer array nums of length n, you want to create an array ans of length 2n where ans[i] == nums[i]
//    and ans[i + n] == nums[i] for 0 <= i < n (0-indexed).
//    Specifically, ans is the concatenation of two nums arrays.
//    Return the array ans.
//    Example:-
//    Input: numbers = [1,2,1]
//    Output: [1,2,1,1,2,1]

    println("---> " + getConcatenatedArray(intArrayOf(1, 2, 1)).contentToString())
}

fun getConcatenatedArray(numbers: IntArray): IntArray {
    val concatenatedArray = IntArray(numbers.size * 2)
    for (index in numbers.indices) {
        concatenatedArray[index] = numbers[index]
        concatenatedArray[index + numbers.size] = numbers[index]
    }
    return concatenatedArray
}