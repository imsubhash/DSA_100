package com.example.dsa_100.array


// https://leetcode.com/problems/divide-array-into-arrays-with-max-difference/?envType=daily-question&envId=2025-06-18

fun divideArray(nums: IntArray, k: Int): Array<IntArray> {
    nums.sort()
    val result = Array(nums.size / 3) { IntArray(3) }
    var index = 0
    for (i in 0..nums.size - 3 step 3) {
        if (nums[i + 2] - nums[i] > k) {
            return emptyArray()
        }
        result[index++] = intArrayOf(nums[i], nums[i + 1], nums[i + 2])
    }
    return result
}