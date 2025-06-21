package com.example.dsa_100.string

import java.util.Arrays
import kotlin.math.min

fun minimumDeletions(word: String, k: Int): Int {
    val freq = IntArray(26)

    for (ch in word.toCharArray()) {
        freq[ch - 'a']++
    }

    Arrays.sort(freq)

    var result = Integer.MAX_VALUE
    var deletedTillNow = 0

    for (i in 0 until 26) {
        val minFreq = freq[i]
        var temp = deletedTillNow

        for (j in 25 downTo i + 1) {
            if (freq[j] == 0) continue
            if (freq[j] - minFreq <= k) {
                break
            }
            temp += freq[j] - (minFreq + k)
        }
        result = min(result, temp)
        deletedTillNow += freq[i]
    }

    return if (result == Integer.MAX_VALUE) 0 else result
}

fun main() {
    val word = "aabcaba"
    val k = 0
    println(minimumDeletions(word, k))
}