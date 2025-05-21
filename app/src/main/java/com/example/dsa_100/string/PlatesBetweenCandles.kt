package com.example.dsa_100.string


fun platesBetweenCandles(s: String, queries: Array<IntArray>): IntArray {
    val n = s.length
    val left = IntArray(n)
    val right = IntArray(n)
    val prefixSum = IntArray(n)

    prefixSum[0] = if (s[0] == '*') 1 else 0
    left[0] = if (s[0] == '|') -1 else 0
    right[n - 1] = if (s[n - 1] == '|') n - 1 else n

    for (i in 1 until n) {
        prefixSum[i] = prefixSum[i - 1] + if (s[i] == '*') 1 else 0
        left[i] = if (s[i] == '|') i else left[i - 1]
    }

    for (i in n - 2 downTo 0) {
        right[i] = if (s[i] == '|') i else right[i + 1]
    }
    val result = IntArray(queries.size)
    for (i in queries.indices) {
        val start = right[queries[i][0]]
        val end = left[queries[i][1]]
        result[i] = if (start >= end) 0 else prefixSum[end] - prefixSum[start]
    }

    return result
}

fun wordBreak(s: String, wordDict: List<String>): Boolean {
    val n = s.length
    val dp = BooleanArray(n + 1)
    dp[0] = true
    for (i in 1..n) {
        for (word in wordDict) {
            val j = i - word.length
            if (j >= 0 && dp[j] && s.substring(j, i) == word) {
                dp[i] = true
                break
            }
        }
    }
    return dp[n]
}

fun main() {
    val s = "||**|*"
    val queries = arrayOf(
        intArrayOf(0, 5),
//        intArrayOf(4, 5),
//        intArrayOf(14, 17),
//        intArrayOf(5, 11),
//        intArrayOf(15, 16)
    )
    val result = platesBetweenCandles(s, queries)
    println(result.contentToString())
}