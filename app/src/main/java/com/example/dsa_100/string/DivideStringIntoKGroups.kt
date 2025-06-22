package com.example.dsa_100.string

fun divideString(s: String, k: Int, fill: Char): Array<String> {
    val result = mutableListOf<String>()
    for (i in 0 until s.length step k) {
        val end = minOf(i + k, s.length)
        var group = s.substring(i, end)
        if (group.length < k) {
            group += fill.toString().repeat(k - group.length)
        }
        result.add(group)
    }
    return result.toTypedArray()
}

fun main() {
    val s = "abcdefghijklm"
    val k = 3
    val fill = 's'
    val result = divideString(s, k, fill)
    println(result.joinToString(", ")) // Output: ["abc", "def", "ghi"]
}