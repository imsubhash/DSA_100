package com.example.dsa_100.array

import java.util.PriorityQueue
import kotlin.math.floor
import kotlin.math.sqrt

fun rangeSum(nums: IntArray, n: Int, left: Int, right: Int): Int {
    val subSums = mutableListOf<Int>()
    val mod = 1_000_000_007

    for (i in nums.indices) {
        var sum = 0
        for (j in i until nums.size) {
            sum += nums[j]
            subSums.add(sum)
        }
    }
    subSums.sort()
    return subSums.subList(left - 1, right).sumOf { it.toLong() }.mod(mod).toInt()
}


fun pickGifts(gifts: IntArray, k: Int): Long {
    val maxHeap = PriorityQueue<Int>(compareByDescending { it })
    val minHeap = PriorityQueue<Int>(compareBy { it })
    maxHeap.addAll(gifts.toList())
    minHeap.addAll(gifts.toList())


    println(maxHeap)
    println(minHeap)

    repeat(k) {
        val max = maxHeap.poll()
        maxHeap.offer(floor(sqrt(max.toDouble())).toInt())
    }
    return maxHeap.sumOf { it.toLong() }
}

fun main() {
    val input = intArrayOf(10, 13, 5, 2, 0, 11)
    pickGifts(input, 0)

}