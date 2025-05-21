package com.example.dsa_100.string

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
        }
        result = key
    }
    return result
}

fun main() {
    val messages = arrayOf("Hello userTwooo", "Hi userThree", "Wonderful day Alice", "Nice day userThree")
    val senders = arrayOf("Alice", "Bob", "Alice", "Bob")
    val result = largestWordCount(messages, senders)
    println(result)
}
