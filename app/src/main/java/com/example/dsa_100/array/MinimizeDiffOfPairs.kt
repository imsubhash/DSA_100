package com.example.dsa_100.array

import java.util.Arrays


private fun countValidPairs(nums: IntArray, threshold: Int): Int {
    var index = 0
    var count = 0
    while (index < nums.size - 1) {
        if (nums[index + 1] - nums[index] <= threshold) {
            count++
            index++
        }
        index++
    }
    return count
}

fun minimizeMax(nums: IntArray, p: Int): Int {
    Arrays.sort(nums)
    val n = nums.size
    if (p == 0) {
        return 0
    }
    var left = 0
    var right = nums[n - 1] - nums[0]

    while (left < right) {
        val mid = left + (right - left) / 2
        if (countValidPairs(nums, mid) >= p) {
            right = mid
        } else {
            left = mid + 1
        }
    }
    return left
}
