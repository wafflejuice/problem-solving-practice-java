package leetcode

fun runningSum(nums: IntArray): IntArray {
    var acc = 0
    return nums.map {
        acc += it
        acc
    }.toIntArray()
}

fun main() {
    assert(runningSum(listOf(1,2,3,4).toIntArray()).contentEquals(listOf(1,3,6,10).toIntArray()))
    assert(runningSum(listOf(1,1,1,1,1).toIntArray()).contentEquals(listOf(1,2,3,4,5).toIntArray()))
    assert(runningSum(listOf(3,1,2,10,1).toIntArray()).contentEquals(listOf(3,4,6,16,17).toIntArray()))
}
