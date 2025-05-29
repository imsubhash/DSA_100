package com.example.dsa_100.array

import java.util.PriorityQueue

class Solution {
    fun getOrder(tasks: Array<IntArray>): IntArray {
        val n = tasks.size

        val sortedTasks = Array(n) { i ->
            intArrayOf(tasks[i][0], tasks[i][1], i) // [enqueueTime, processingTime, index]
        }

        sortedTasks.sortWith(compareBy({ it[0] }, { it[1] }, { it[2] }))

        val result = mutableListOf<Int>()
        var time: Long = 0
        var index = 0

        val pq = PriorityQueue(compareBy<Pair<Int, Int>> { it.first }.thenBy { it.second })

        while (index < n || pq.isNotEmpty()) {
            if (pq.isEmpty() && time < sortedTasks[index][0]) {
                time = sortedTasks[index][0].toLong()
            }

            while (index < n && sortedTasks[index][0] <= time) {
                pq.add(Pair(sortedTasks[index][1], sortedTasks[index][2]))
                index++
            }

            val (procTime, idx) = pq.poll()
            time += procTime
            result.add(idx)
        }

        return result.toIntArray()
    }
}
