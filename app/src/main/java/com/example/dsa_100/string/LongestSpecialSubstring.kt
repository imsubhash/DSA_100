package com.example.dsa_100.string

// Brute Force
fun maximumLength(s: String): Int {
    val n = s.length
    val map = mutableMapOf<String, Int>()
    for (i in s.indices) {
        var curr = StringBuilder()
        for (j in i until n) {
            if (curr.isEmpty() || curr.last() == s[j]) {
                curr.append(s[j])
                map[curr.toString()] = map.getOrDefault(curr.toString(), 0) + 1
            } else {
                break
            }
        }
    }
    var result = 0
    for ((str, count) in map) {
        if (count >= 3 && str.length > result) {
            result = str.length
        }
    }

    return if (result == 0) -1 else result
}

//Optimized one
fun maximumLength2(s: String): Int {
    val countMap = mutableMapOf<Char, MutableMap<Int, Int>>()
    var i = 0
    while (i < s.length) {
        val ch = s[i]
        var len = 1
        while (i + 1 < s.length && s[i + 1] == ch) {
            len++
            i++
        }
        for (l in 1..len) {
            countMap.getOrPut(ch) { mutableMapOf() }.merge(l, len - l + 1, Int::plus)
        }
        i++
    }

    var maxLen = -1
    for (lengths in countMap.values) {
        for ((len, count) in lengths) {
            if (count >= 3) {
                maxLen = maxOf(maxLen, len)
            }
        }
    }

    return maxLen
}
