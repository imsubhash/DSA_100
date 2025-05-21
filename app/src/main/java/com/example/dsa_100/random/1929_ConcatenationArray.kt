package com.example.dsa_100.random

fun getConcatenation(nums: IntArray): IntArray {
    val n = nums.size
    val result = IntArray(n * 2)

    for (i in 0 until n) {
        result[i] = nums[i]
        result[n + i] = nums[i]
    }

    return result
}

fun main() {
    val input = intArrayOf(1, 2, 1)
    val result = getConcatenation(input)
    println(result.toList())
}