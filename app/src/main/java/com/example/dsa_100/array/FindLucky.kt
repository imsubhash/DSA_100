package com.example.dsa_100.array

fun findLucky(arr: IntArray): Int {
    val map = mutableMapOf<Int, Int>()
    for (num in arr) {
        map[num] = map.getOrDefault(num, 0) + 1
    }
    var maxLucky = -1
    for ((key, value) in map) {
        if (key == value && key > maxLucky) {
            maxLucky = key
        }
    }
    return maxLucky
}

fun main() {
    val arr = intArrayOf(2, 2, 3, 4)
    println(findLucky(arr))
}