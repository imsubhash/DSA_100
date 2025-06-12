package com.example.dsa_100.array

import kotlin.math.abs

//https://leetcode.com/problems/maximum-difference-between-adjacent-elements-in-a-circular-array/description/?envType=daily-question&envId=2025-06-12

fun maxAdjacentDistance(nums: IntArray): Int {
    val n = nums.size
    var max = abs(nums[0] - nums[n - 1])
    for (i in 0 until n - 1) {
        if (max < abs(nums[i] - nums[i + 1])) {
            max = abs(nums[i] - nums[i + 1])
        }
    }
    return max
}

fun main() {
    val nums = intArrayOf(-4,-2,-3)
    println(maxAdjacentDistance(nums))
}