package com.example.dsa_100.heap

import java.util.PriorityQueue

fun maxEvents(events: Array<IntArray>): Int {
    val pq = PriorityQueue<Int>()
    events.sortBy { it[0] }
    var i = 0
    var res = 0
    var d = 0
    while (!pq.isEmpty() || i < events.size) {
        if (pq.isEmpty()) {
            d = events[i][0]
        }
        while (i < events.size && events[i][0] <= d) {
            pq.offer(events[i++][1])
        }
        if (!pq.isEmpty()) {
            pq.poll()
            ++res
        }
        ++d
        while (!pq.isEmpty() && pq.peek() < d) {
            pq.poll()
        }
    }
    return res
}


fun main() {
    val events = arrayOf(
        intArrayOf(1, 2),
        intArrayOf(2, 3),
        intArrayOf(3, 4)
    )
    println(maxEvents(events))
}