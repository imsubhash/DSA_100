package com.example.dsa_100.math

import kotlin.math.abs

class DetectSquares {
    private val cntPoints = Array(1001) { IntArray(1001) }
    private val points = mutableListOf<IntArray>()

    fun add(p: IntArray) {
        cntPoints[p[0]][p[1]] += 1
        points.add(p)
    }

    fun count(p1: IntArray): Int {
        val x1 = p1[0]
        val y1 = p1[1]
        var ans = 0
        for (p3 in points) {
            val x3 = p3[0]
            val y3 = p3[1]
            if (abs(x1 - x3) == 0 || abs(x1 - x3) != abs(y1 - y3)) {
                continue
            }
            ans += cntPoints[x1][y3] * cntPoints[x3][y1]
        }
        return ans
    }
}
