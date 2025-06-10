package com.example.dsa_100.string

fun maxDifference(s: String): Int {
    val frequencyMap = mutableMapOf<Char, Int>()

    for (char in s) {
        frequencyMap[char] = frequencyMap.getOrDefault(char, 0) + 1
    }

    var maxEven = Int.MIN_VALUE
    var minOdd = Int.MAX_VALUE

    for ((_, count) in frequencyMap) {
        if (count % 2 == 0) {
            if (count > maxEven) {
                maxEven = count
            }
        } else {
            if (count < minOdd) {
                minOdd = count
            }
        }
    }

    if (maxEven == Int.MIN_VALUE || minOdd == Int.MAX_VALUE) {
        return 0
    }

    return maxEven - minOdd
}
