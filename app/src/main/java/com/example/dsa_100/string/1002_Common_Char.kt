package com.example.dsa_100.string

//Input: words = ["bella","label","roller"]
//Output: ["e","l","l"]
fun commonChars(words: Array<String>): List<String> {
    if (words.isEmpty()) return listOf()
    val map = mutableMapOf<Char, Int>()
    val common = words[0]
    for (i in 0..common.length - 1) {
        map[common[i]] = map.getOrDefault(common[i], 0) + 1
    }

    for (word in 1..words.size-1) {

    }
    println(map)
    return listOf()
}

fun main() {
    val input = arrayOf("bella", "label", "roller")
    val result = commonChars(input)
}