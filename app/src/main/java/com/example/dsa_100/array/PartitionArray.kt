package com.example.dsa_100.array

// https://leetcode.com/problems/partition-array-such-that-maximum-difference-is-k/?envType=daily-question&envId=2025-06-19

fun partitionArray(nums: IntArray, k: Int): Int {
    nums.sort()
    var count = 1
    var minVal = nums[0]
    for (i in 1 until nums.size) {
        if (nums[i] - minVal > k) {
            count++
            minVal = nums[i]
        }
    }
    return count
}

fun main() {
    val nums = intArrayOf(3, 6, 1, 2, 5)
    val k = 2
    println(partitionArray(nums, k))
}
