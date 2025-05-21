package com.example.dsa_100.array

fun twoSum(nums: IntArray, target: Int): IntArray {
    val map = mutableMapOf<Int, Int>()

    for (i in nums.indices) {
        if (map.containsKey(target - nums[i])) {
            return intArrayOf(map.getValue(target - nums[i]), i)
        }
        map[nums[i]] = i
    }

    return intArrayOf(0, 0)
}



fun main() {
    val nums = intArrayOf(2, 7, 11, 15)
    val target = 9
    val result = twoSum(nums, target)
    println(result.joinToString())
}