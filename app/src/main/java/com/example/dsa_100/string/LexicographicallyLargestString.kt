package com.example.dsa_100.string

// https://leetcode.com/problems/find-the-lexicographically-largest-string-from-the-box-i/

fun answerString(word: String, numFriends: Int): String {
    val n = word.length
    if (numFriends == 1) {
        return word
    }

    var result = ""
    val longestPossible = n - (numFriends - 1)

    for (i in 0 until n) {
        val canTakeLength = minOf(longestPossible, n - i)
        val substring = word.substring(i, i + canTakeLength)
        if (substring > result) {
            result = substring
        }
    }

    return result
}
