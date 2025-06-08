package com.example.dsa_100.array

fun lexicalOrder(n: Int): List<Int> {
    val result = mutableListOf<Int>()
    fun dfs(current: Int, n: Int) {
        if (current > n) return
        result.add(current)
        for (i in 0..9) {
            dfs(current * 10 + i, n)
        }
    }
    for ( i in 1..9) {
        dfs(i, n)
    }
    return result
}

fun main() {
    val n = 13
    val result = lexicalOrder(n)
    println(result)
}