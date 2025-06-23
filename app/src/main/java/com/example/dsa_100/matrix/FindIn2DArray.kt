package com.example.dsa_100.matrix

fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
    val m = matrix.size
    val n = matrix[0].size
    var l = 0
    var r = m * n - 1
    while (l <= r) {
        val mid = l + (r - l) / 2
        val row = mid / n
        val col = mid % n
        if (matrix[row][col] == target) {
            return true
        } else if (matrix[row][col] < target) {
            l = mid + 1
        } else {
            r = mid - 1
        }
    }
    return false
}

fun main() {
    val matrix = arrayOf(
        intArrayOf(1, 3, 5, 7),
        intArrayOf(10, 11, 16, 20),
        intArrayOf(23, 30, 34, 60)
    )
    val target = 3
    println(searchMatrix(matrix, target))
}