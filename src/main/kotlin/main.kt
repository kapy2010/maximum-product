import kotlin.math.max

fun main() {
    val input1 = listOf(1, 2, 10, -20, 9)
    val input2 = listOf(-5, -10, -20, -9, -1)

    println(maximumProduct(input1))
    println(maximumProduct(input2))
}

fun maximumProduct(nums: List<Int>): Int {
    var max1 = Int.MIN_VALUE
    var max2 = Int.MIN_VALUE
    var max3 = Int.MIN_VALUE
    var min1 = Int.MAX_VALUE
    var min2 = Int.MAX_VALUE

    nums.forEach {
        if (it <= min1) {
            min2 = min1
            min1 = it
        } else if (it <= min2) {
            min2 = it
        }

        when {
            it >= max1 -> {
                max3 = max2
                max2 = max1
                max1 = it
            }
            it >= max2 -> {
                max3 = max2
                max2 = it
            }
            it >= max3 -> {
                max3 = it
            }
        }
    }

    return max(min1 * min2 * max1, max1 * max2 * max3)
}