package com.example.dsa_100.string


fun kthCharacter(k: Int): Char {

    val sb = StringBuilder("a")
    while (sb.length < k) {
        val size = sb.length
        for (i in 0 until size) {
            sb.append('a' + ((sb[i] - 'a') + 1) % 26)
        }
    }
    return sb[k - 1]

    // Another approach with just one line code using bit manipulation
    // return ('a' + Integer.bitCount(k - 1))
}