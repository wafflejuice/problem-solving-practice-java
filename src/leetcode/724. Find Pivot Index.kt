package leetcode

fun pivotIndex(nums: IntArray): Int {
    val size = nums.size

    val ls = Array(size) {0}
    var leftAcc = 0
    for (i in 0 until size) {
        ls[i] = leftAcc
        leftAcc += nums[i]
    }

    val rs = Array(size) {0}
    var rightAcc = 0
    for (i in (size-1) downTo 0) {
        rs[i] = rightAcc
        rightAcc += nums[i]
    }

    for (i in 0 until size) {
        if (ls[i] == rs[i]) {
            return i
        }
    }

    return -1
}

fun main() {
    assert(3 == pivotIndex(intArrayOf(1,7,3,6,5,6)))
    assert(-1 ==pivotIndex(intArrayOf(1,2,3)))
    assert(0 == pivotIndex(intArrayOf(2,1,-1)))
}
