package com.example.dsa_100.string

import java.util.Stack

//Remove substring "ab" and gain x points.
//Remove substring "ba" and gain y points.
// cdbcbbaaabab

fun removeSubstr(s: String, sub: String): Pair<String, Int> {
    val st = Stack<Char>()
    var count = 0
    for (c in s) {
        if (st.isNotEmpty() && st.peek() == sub[0] && c == sub[1]) {
            st.pop()
            count++
        } else {
            st.push(c)
        }
    }
    val tempStr = StringBuilder()
    while (st.isNotEmpty()) {
        tempStr.append(st.pop())
    }
    return Pair(tempStr.reverse().toString(), count)
}

fun maximumGain(s: String, x: Int, y: Int): Int {
    var res = 0
    val firstSub = if (x >= y) "ab" else "ba"
    val secondSub = if (x >= y) "ba" else "ab"
    val firstResult = removeSubstr(s, firstSub)
    res += firstResult.second * maxOf(x, y)
    val secondResult = removeSubstr(firstResult.first, secondSub)
    res += secondResult.second * minOf(x, y)
    return res
}

fun main() {
    val s = "cdbcbbaaabab"
    val x = 4
    val y = 4

    val result = maximumGain(s, x, y)
    println(result)
}