package com.example.dsa_100.array

fun findDuplicate(nums: IntArray): Int {
    val map = mutableMapOf<Int, Int>()
    for (i in nums.indices) {
        if (map.containsKey(nums[i])) {
            return nums[i]
        } else {
            map[nums[i]] = i
        }
    }
    println(map)
    return 0
}

fun main() {
    val nums = intArrayOf(1, 3, 4, 2, 3)
    val result = findDuplicate(nums)
    println(result)
}