package com.example.dsa_100.practice

import kotlin.math.max

fun maxSum(nums: IntArray): Int {
    val set = mutableSetOf<Int>()
    var result = 0
    var maxNeg = Int.MIN_VALUE

    for (num in nums) {
        if (num <= 0) {
            maxNeg = max(maxNeg, num)
        } else {
            set.add(num)
        }
    }
    for (item in set) {
        result += item
    }

    return if (result == 0) maxNeg else result
}

fun main() {
    val arr = intArrayOf(-15,0)
    println(maxSum(arr))
}