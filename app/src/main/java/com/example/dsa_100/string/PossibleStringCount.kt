package com.example.dsa_100.string

class Solution {
    fun possibleStringCount(word: String): Int {
        var ans = 1
        for (i in 1 until word.length) {
            if (word[i - 1] == word[i]) {
                ans++
            }
        }
        return ans
    }
}