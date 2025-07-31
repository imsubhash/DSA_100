package com.example.dsa_100.array

fun countHillValley(nums: IntArray): Int {
    var i = 0
    var j = 1
    var result = 0
    while (j + 1 < nums.size) {
        if (nums[j] > nums[i] && nums[j] > nums[j + 1] ||
            nums[j] < nums[i] && nums[j] < nums[j + 1]
        ) {
            result++
            i = j
        }
        j++
    }
    return result
}

fun main() {
    val nums = intArrayOf(6, 6, 5, 5, 4, 1)
    val result = countHillValley(nums)
    println(result)
}