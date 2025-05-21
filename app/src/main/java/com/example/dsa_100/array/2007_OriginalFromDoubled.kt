package com.example.dsa_100.array


fun findOriginalArray(changed: IntArray): IntArray {
    if (changed.size % 2 != 0) return intArrayOf()

    val map = mutableMapOf<Int, Int>()
    for (num in changed) {
        map[num] = map.getOrDefault(num, 0) + 1
    }

    val sorted = changed.sorted()
    val result = mutableListOf<Int>()

    for (num in sorted) {
        if (map[num] == 0) continue
        val double = num * 2
        if (map.getOrDefault(double, 0) == 0) {
            return intArrayOf()
        }
        result.add(num)
        map[num] = map[num]!! - 1
        map[double] = map[double]!! - 1

    }
    return result.toIntArray()
}

fun largestWordCount(messages: Array<String>, senders: Array<String>): String {
    val map = mutableMapOf<String, Int>()
    for (i in messages.indices) {
        val count = messages[i].split(" ").size
        map[senders[i]] = map.getOrDefault(senders[i], 0) + count
    }
    var max = 0
    var result = ""
    for (key in map.keys) {
        if (map[key]!! > max) {
            max = map[key]!!
            result = key
        }
    }
    return result
}


fun main() {

}