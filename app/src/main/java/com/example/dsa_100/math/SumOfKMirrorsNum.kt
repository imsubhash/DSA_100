package com.example.dsa_100.math

import kotlin.math.pow

class Solution {
    fun kMirror(k: Int, n: Int): Long {
        var sum = 0L
        var count = 0
        var length = 1

        while (count < n) {
            // Generate palindromes of current length
            for (num in generatePalindromes(length)) {
                if (isPalindrome(num.toString(k))) {
                    sum += num
                    count++
                    if (count == n) break
                }
            }
            length++
        }
        return sum
    }

    fun isPalindrome(s: String): Boolean {
        return s == s.reversed()
    }

    fun generatePalindromes(length: Int): List<Long> {
        val palindromes = mutableListOf<Long>()
        val halfLength = (length + 1) / 2
        val start = 10.0.pow((halfLength - 1).toDouble()).toLong()
        val end = 10.0.pow(halfLength.toDouble()).toLong()

        for (i in start until end) {
            val half = i.toString()
            val palindrome = if (length % 2 == 0) {
                (half + half.reversed()).toLong()
            } else {
                (half + half.dropLast(1).reversed()).toLong()
            }
            palindromes.add(palindrome)
        }
        return palindromes
    }
}

fun main() {
    val solution = Solution()
    println(solution.kMirror(2, 5)) // Output: 25
}