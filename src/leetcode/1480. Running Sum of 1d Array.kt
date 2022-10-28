package leetcode

import kotlin.test.assertContentEquals

class Solution {
    fun runningSum(nums: IntArray): IntArray {
        var acc = 0
        return nums.map {
            acc += it
            acc
        }.toIntArray()
    }
}

fun main() {
    assertContentEquals(Solution().runningSum(listOf(1,2,3,4).toIntArray()), listOf(1,3,6,10).toIntArray())
    assertContentEquals(Solution().runningSum(listOf(1,1,1,1,1).toIntArray()), listOf(1,2,3,4,5).toIntArray())
    assertContentEquals(Solution().runningSum(listOf(3,1,2,10,1).toIntArray()), listOf(3,4,6,16,17).toIntArray())
}
