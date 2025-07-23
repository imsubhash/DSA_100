package com.example.dsa_100.array

fun maximumUniqueSubarray(nums: IntArray): Int {
    var left = 0
    var right = 0
    var maxSum = 0
    var currentSum = 0
    val set = mutableSetOf<Int>()

    while (right < nums.size) {
        if (!set.contains(nums[right])) {
            set.add(nums[right])
            currentSum += nums[right]
            maxSum = maxOf(maxSum, currentSum)
            right++
        } else {
            set.remove(nums[left])
            currentSum -= nums[left]
            left++
        }
    }
    return maxSum
}

fun main() {
    val nums = intArrayOf(5,2,1,2,5,2,1,2,5)
    println(maximumUniqueSubarray(nums))
}