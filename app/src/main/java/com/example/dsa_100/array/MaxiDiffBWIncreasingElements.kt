package com.example.dsa_100.array

import kotlin.math.max

//https://leetcode.com/problems/maximum-difference-between-increasing-elements/?envType=daily-question&envId=2025-06-16

// [7,1,5,4]

fun maximumDifference(nums: IntArray): Int {
    var minElement = nums[0]
    var maxDiff = -1
    for (i in 1 until nums.size) {
        if (nums[i] > minElement) {
            maxDiff = max(maxDiff, nums[i] - minElement)
        } else {
            minElement = nums[i]
        }

    }
    return maxDiff
}

fun main() {
    println(
        maximumDifference(
            intArrayOf(
                7, 1, 5, 4
            )
        )
    )
}