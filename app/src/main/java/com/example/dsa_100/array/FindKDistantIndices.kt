package com.example.dsa_100.array

fun findKDistantIndices(nums: IntArray, key: Int, k: Int): List<Int> {
    val result = mutableListOf<Int>()
    for (i in nums.indices) {
        if (nums[i] == key) {
            val start = maxOf(0, i - k)
            val end = minOf(nums.size - 1, i + k)
            for (j in start..end) {
                if (j !in result) {
                    result.add(j)
                }
            }
        }
    }
    return result
}



fun main() {
    val nums = intArrayOf(3, 4, 9, 1, 3, 9, 5)
    val key = 9
    val k = 1
    val result = findKDistantIndices(nums, key, k)
    println(result)
}