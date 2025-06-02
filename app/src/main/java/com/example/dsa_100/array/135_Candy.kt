package com.example.dsa_100.array

import kotlin.math.max

// https://leetcode.com/problems/candy/description/

fun candy(ratings: IntArray): Int {
    val n = ratings.size
    val candies = IntArray(n) { 1 }

    for (i in 1 until n) {
        if (ratings[i] > ratings[i - 1]) {
            candies[i] = max(candies[i], candies[i - 1] + 1)
        }
    }

    for (i in n - 2 downTo 0) {
        if (ratings[i] > ratings[i + 1]) {
            candies[i] = max(candies[i], candies[i + 1] + 1)
        }
    }

    return candies.sum()
}

fun main() {
    val ratings = intArrayOf(1, 0, 2)
    println(candy(ratings))  // Output: 5
}