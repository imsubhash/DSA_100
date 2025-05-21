package com.example.dsa_100.string


fun isIsomorphic(s: String, t: String): Boolean {
    if (s.length != t.length) return false
    val stot = mutableMapOf<Char, Char>()
    val ttos = mutableMapOf<Char, Char>()

    for (i in s.indices) {
        val charS = s[i]
        val charT = t[i]

        if (stot.contains(charS)) {
            if (stot[charS] != charT) return false
        } else {
            stot[charS] = charT
        }
        if (ttos.contains(charT)) {
            if (ttos[charT] != charS) return false
        } else {
            ttos[charT] = charS
        }
    }

    return true
}

fun main() {
    val s = "foo"
    val t = "bar"
    val result = isIsomorphic(s, t)
    println(result)
}