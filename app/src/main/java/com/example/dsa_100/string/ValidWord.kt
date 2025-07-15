package com.example.dsa_100.string

fun isValid(word: String): Boolean {
    if (word.length < 3) return false
    var hasVowel = false
    var hasConsonant = false
    for (c in word) {
        if (Character.isLetter(c)) {
            val ch = c.lowercaseChar()
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                hasVowel = true
            } else {
                hasConsonant = true
            }
        } else if (!Character.isDigit(c)) {
            return false
        }
    }
    return return hasVowel && hasConsonant
}

fun main() {
    println(isValid("aabb"))
    println(isValid("a3$/e"))
    println(isValid("abcabc"))
    println(isValid("abcd"))
}