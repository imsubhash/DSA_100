package com.example.dsa_100.string

fun makeFancyString(s: String): String {
    val sb = StringBuilder()
    var count = 1
    sb.append(s[0])
    for (i in 1 until s.length) {
        if (s[i] == s[i - 1]) {
            count++
        } else {
            count = 1
        }
        if (count < 3) {
            sb.append(s[i])
        }
    }
    return sb.toString()
}

fun main() {
    val s = "leeetcode"
    println(makeFancyString(s))
}