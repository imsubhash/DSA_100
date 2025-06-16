package com.example.dsa_100.string

fun minMaxDifference(num: Int): Int {
    var numStr = num.toString()
    var t = numStr
    var pos = 0
    while (pos < t.length && t[pos] == '9') {
        pos++
    }
    if (pos < numStr.length) {
        numStr = numStr.replace(t[pos], '9')
    }
    t = t.replace(t[0], '0')
    return numStr.toInt() - t.toInt()
}

fun main() {
    println(minMaxDifference(11891))
}