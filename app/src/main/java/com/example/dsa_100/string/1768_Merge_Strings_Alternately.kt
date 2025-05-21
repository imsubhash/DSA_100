package com.example.dsa_100.string

fun mergeAlternately(word1: String, word2: String): String {
    val result = StringBuilder()
    var i = 0
    var j = 0
    val n = word1.length
    val m = word2.length
    while (i < n && j < m) {
        result.append(word1[i])
        result.append(word2[j])
        i++
        j++
    }
    while (i < n) {
        result.append(word1[i])
        i++
    }
    while (j < m) {
        result.append(word2[j])
        j++
    }
    return result.toString()
}

fun main() {
    val word1 = "abc"
    val word2 = "pqrst"
    val result = mergeAlternately(word1, word2)
    println(result)
}