package com.example.dsa_100.string

import kotlin.math.sqrt

fun numberOfSubstrings(s: String): Int {
    val n = s.length
    val maxZeros = sqrt(n.toDouble()).toInt()
    var result = 0

    for (i in 0 until n) {
        var ones = 0
        var zeros = 0

        for (j in i until n) {
            if (s[j] == '1') ones++
            else zeros++
            if (zeros > maxZeros) break
            if (ones >= zeros * zeros) result++
        }
    }
    return result
}

fun main() {
    val input = "00011"
    val result = numberOfSubstrings(input)
    println(result)
}