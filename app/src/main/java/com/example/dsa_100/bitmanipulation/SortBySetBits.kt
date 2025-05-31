package com.example.dsa_100.bitmanipulation

private fun setBit(n: Int): Int {
    var count = 0
    var num = n
    while (num != 0) {
        count += num and 1
        num = num shr 1
    }
    return count
}

fun sortByBits(arr: IntArray): IntArray {
    val map = sortedMapOf<Int, MutableList<Int>>()
    for (num in arr) {
        val bitCount = setBit(num)
        map.getOrPut(bitCount) { mutableListOf() }.add(num)
    }

    val result = mutableListOf<Int>()
    for ((_, nums) in map) {
        nums.sort()
        result.addAll(nums)
    }

    return result.toIntArray()
}

fun main() {
    val arr = intArrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8)
    val result = sortByBits(arr)
    println(result.toMutableList())
}