package com.example.dsa_100.array


fun numEquivDominoPairs(dominoes: Array<IntArray>): Int {
    val num = IntArray(100)
    var ret = 0
    for (domino in dominoes) {
        val valKey = if (domino[0] < domino[1]) {
            domino[0] * 10 + domino[1]
        } else {
            domino[1] * 10 + domino[0]
        }
        ret += num[valKey]
        num[valKey]++
    }
    return ret
}
