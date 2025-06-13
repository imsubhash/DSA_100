package com.example.dsa_100.string

import java.util.LinkedList
import java.util.PriorityQueue


fun topKFrequent(words: Array<String>, k: Int): List<String> {

    val wordCounts = mutableMapOf<String, Int>()
    for (word in words) {
        wordCounts[word] = wordCounts.getOrDefault(word, 0) + 1
    }

    val minHeap = PriorityQueue<Pair<String, Int>>(
        compareBy<Pair<String, Int>> { it.second }
            .thenByDescending { it.first }
    )

    for ((word, count) in wordCounts) {
        minHeap.offer(Pair(word, count))
        if (minHeap.size > k) {
            minHeap.poll()
        }
    }

    val result = LinkedList<String>()
    while (minHeap.isNotEmpty()) {
        result.addFirst(minHeap.poll().first)
    }

    return result
}
