package com.example.dsa_100.array


fun maxProfit(prices: IntArray): Int {

    var maxProfit = 0
    var minPrice = Int.MAX_VALUE

    for (price in prices) {
        if (price < minPrice) {
            minPrice = price
        } else if (price - minPrice > maxProfit) {
            maxProfit = price - minPrice
        }
    }

    return maxProfit
}

fun main() {
    val nums = intArrayOf(7,6,4,3,1)
    val result = maxProfit(nums)
    println(result)
}