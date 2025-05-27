package com.example.dsa_100.array

import kotlin.math.max

fun binarySearch(target: Int, nums: IntArray, k: Int, prefixSum: IntArray): Int {
    var l = 0
    var r = target
    var result = 0
    while (l <= r) {
        val mid = l + (r - l) / 2
        val count = (target - mid) + 1
        val windowSum = count * nums[target]
        val originalSum = prefixSum[target] - prefixSum[mid] + nums[mid]
        val operations = windowSum - originalSum
        if (operations > k) {
            l = mid + 1
        } else {
            result = mid
            r = mid - 1
        }
    }
    return target - result + 1
}

fun maxFrequency(nums: IntArray, k: Int): Int {
    nums.sort()
    val prefixSum = IntArray(nums.size)
    prefixSum[0] = nums[0]
    for (i in 1 until nums.size) {
        prefixSum[i] = prefixSum[i - 1] + nums[i]
    }
    var result = 0
    for (i in nums.indices) {
        val freq = binarySearch(i, nums, k, prefixSum)
        result = max(result, freq)
    }

    return result
}

fun maxFrequencyWithSlidingWindow(nums: IntArray, k: Int): Int {
    nums.sort()
    var left = 0
    var total: Long = 0
    var result = 0

    for (right in nums.indices) {
        total += nums[right]

        // Check if current window is valid
        while ((right - left + 1).toLong() * nums[right] - total > k) {
            total -= nums[left]
            left++
        }

        result = maxOf(result, right - left + 1)
    }

    return result
}

fun main() {
    val ip = intArrayOf(3,9,6)
    val k = 2
    val result = maxFrequencyWithSlidingWindow(ip, k)
    println(result)
}