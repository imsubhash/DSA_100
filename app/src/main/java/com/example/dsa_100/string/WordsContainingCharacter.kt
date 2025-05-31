package com.example.dsa_100.string

fun findWordsContaining(words: Array<String>, x: Char): List<Int> {
    val result = mutableListOf<Int>()
    for (i in words.indices) {
        if (words[i].contains(x)) {
            result.add(i)
        }
    }
    return result
}

fun main() {
    val input = arrayOf("abc","bcd","aaaa","cbc")
    val x = 'z'
    val result = findWordsContaining(input, x)
    println(result)
}