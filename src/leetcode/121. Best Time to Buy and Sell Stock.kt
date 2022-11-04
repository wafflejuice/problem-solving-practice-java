package leetcode

fun maxProfit(prices: IntArray): Int {
    var buyDay = 0
    var sellDay = 1
    var maxProfit = 0
    while (sellDay < prices.size) {
        val profit = prices[sellDay] - prices[buyDay]
        if (profit <= 0) {
            buyDay = sellDay
            sellDay++
        }
        else {
            maxProfit = maxOf(maxProfit, profit)
            sellDay++
        }
    }

    return maxProfit
}

fun main() {
    assert(maxProfit(intArrayOf(7,1,5,3,6,4)) == 5)
    assert(maxProfit(intArrayOf(7,6,4,3,1)) == 0)
}
