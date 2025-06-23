package com.example.dsa_100.string


fun isIsomorphic(s: String, t: String): Boolean {
    if (s.length != t.length) return false

    val map = mutableMapOf<Char, Char>()

    for (i in s.indices) {
        val charS = s[i]
        val charT = t[i]

        if (map.containsKey(charS)) {
            // Check if the existing mapping matches current t's character
            if (map[charS] != charT) return false
        } else {
            // Check if charT is already mapped to another charS (bijective check)
            if (map.containsValue(charT)) return false
            map[charS] = charT
        }
    }

    return true
}

fun main() {
    val s = "paper"
    val t = "title"
    val result = isIsomorphic(s, t)
    println(result)
}