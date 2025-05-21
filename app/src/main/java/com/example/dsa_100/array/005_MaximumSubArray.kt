package com.example.dsa_100.array

fun maxSubArray(nums: IntArray): Int {
    var result = nums[0]
    var maxEnding = nums[0]

    for (i in 1 until nums.size) {
        maxEnding = (maxEnding + nums[i]).coerceAtLeast(nums[i])
        result = result.coerceAtLeast(maxEnding)
    }
    return result
}

fun main() {
    val nums = intArrayOf(-2,1,-3,4,-1,2,1,-5,4)
    val result = maxSubArray(nums)
    println(result)
}