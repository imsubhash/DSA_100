package com.example.dsa_100.practice

fun findInSortedMatrix(matrix: Array<IntArray>, target: Int): Boolean {
    val m = matrix.size
    val n = matrix[0].size
    var l = 0
    var r = m * n - 1
    while (l <= r) {
        val mid = l + (r - l) / 2
        val row = mid / n
        val col = mid % n
        if (target == matrix[row][col]) {
            return true
        } else if (target > matrix[row][col]) {
            l = mid + 1
        } else {
            r = mid - 1
        }
    }
    return false
}

fun main() {
    val input = arrayOf(
        intArrayOf(1, 3, 5, 7),
        intArrayOf(10, 11, 16, 20),
        intArrayOf(23, 30, 34, 60)
    )
    val target = 5
    val result = findInSortedMatrix(input, target)
    println(result)
}