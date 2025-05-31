package com.example.dsa_100.array

fun swap(nums: IntArray, i: Int, j: Int) {
    val temp = nums[i]
    nums[i] = nums[j]
    nums[j] = temp
}

fun sortColors(nums: IntArray): Unit {
    var low = 0
    var mid = 0
    var high = nums.lastIndex

    while (mid <= high) {
        when (nums[mid]) {
            0 -> {
                swap(nums, low, mid)
                low++
                mid++
            }

            1 -> {
                mid++
            }

            2 -> {
                swap(nums, mid, high)
                high--
            }
        }
    }
}

fun main() {
    val input = intArrayOf(1, 0, 0, 1, 1, 1, 2, 2, 0, 0, 2, 1, 1, 0)
    sortColors(input)
    println(input.toMutableList())
}