package com.example.dsa_100.array

class FindSumPairs(nums1: IntArray, nums2: IntArray) {

    private val nums1: IntArray = nums1
    private val nums2: IntArray = nums2
    private val map: MutableMap<Int, Int> = HashMap()

    init {
        for (num in nums2) {
            map[num] = map.getOrDefault(num, 0) + 1
        }
    }

    fun add(index: Int, `val`: Int) {
        map[nums2[index]] = map[nums2[index]]!! - 1
        nums2[index] += `val`
        map[nums2[index]] = map.getOrDefault(nums2[index], 0) + 1
    }

    fun count(tot: Int): Int {
        var count = 0
        for (num in nums1) {
            count += map.getOrDefault(tot - num, 0)
        }
        return count
    }
}

fun main() {
    val findSumPairs = FindSumPairs(intArrayOf(1, 1, 2, 2, 2, 3), intArrayOf(1, 4, 5, 2, 5, 4))
    println(findSumPairs.count(7))
    findSumPairs.add(3, 2)
    println(findSumPairs.count(8))
    }