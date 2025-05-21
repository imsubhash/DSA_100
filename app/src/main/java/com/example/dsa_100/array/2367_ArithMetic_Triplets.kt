package com.example.dsa_100.array

fun arithmeticTriplets(nums: IntArray, diff: Int): Int {
    val map = mutableMapOf<Int, Int>()
    var count = 0
    for (i in nums.indices) {
        map[nums[i]] = map.getOrDefault(nums[i], 0)
    }
    for (i in nums.indices) {
        if (map.containsKey(nums[i] + diff) && map.containsKey(nums[i] + 2 * diff)) {
            count++
        }
    }

    return count
}

fun main() {

}