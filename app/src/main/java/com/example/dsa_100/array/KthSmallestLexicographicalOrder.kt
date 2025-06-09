package com.example.dsa_100.array

//https://leetcode.com/submissions/detail/1658853928/

class Solution {
    fun findKthNumber(n: Int, k: Int): Int {
        var curr = 1
        var kLeft = k - 1

        fun countSteps(n: Int, curr: Long, next: Long): Int {
            var steps = 0
            var first = curr
            var last = next
            while (first <= n) {
                steps += (minOf(n + 1L, last) - first).toInt()
                first *= 10
                last *= 10
            }
            return steps
        }

        while (kLeft > 0) {
            val steps = countSteps(n, curr.toLong(), (curr + 1).toLong())
            if (steps <= kLeft) {
                curr++
                kLeft -= steps
            } else {
                curr *= 10
                kLeft--
            }
        }

        return curr
    }
}