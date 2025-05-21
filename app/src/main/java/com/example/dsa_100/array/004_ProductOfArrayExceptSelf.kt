package com.example.dsa_100.array


fun productExceptSelf(nums: IntArray): IntArray {
    val n = nums.size
    val left = IntArray(n)
    val right = IntArray(n)
    val result = IntArray(n)

    left[0] = 1
    right[n - 1] = 1

    // left : [1, 1, 2, 6]
    for (i in 1 until n) {
        left[i] = left[i - 1] * nums[i - 1]
    }

    // right : [24, 12, 4, 1]
    for (i in n - 2 downTo 0) {
        right[i] = right[i + 1] * nums[i + 1]
    }

    // result : [24, 12, 8, 6]
    for (i in 0 until n) {
        result[i] = left[i] * right[i]
    }
    return result
}

fun main() {
    val input = intArrayOf(1, 2, 3, 4)
    val result = productExceptSelf(input)
    println(result.joinToString())
}