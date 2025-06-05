package com.example.dsa_100.string

// https://leetcode.com/problems/lexicographically-smallest-equivalent-string/description/?envType=daily-question&envId=2025-06-05

fun smallestEquivalentString(s1: String, s2: String, baseStr: String): String {
    val parent = mutableMapOf<Char, Char>()
    fun find(x: Char): Char {
        if (!parent.containsKey(x)) {
            parent[x] = x
            return x
        }
        var current = x
        while (parent[current] != current) {
            parent[current] = parent[parent[current]!!]!!
            current = parent[current]!!
        }
        return current
    }

    fun union(x: Char, y: Char) {
        val rootX = find(x)
        val rootY = find(y)
        if (rootX != rootY) {
            if (rootX < rootY) {
                parent[rootY] = rootX
            } else {
                parent[rootX] = rootY
            }
        }
    }

    for (i in s1.indices) {
        union(s1[i], s2[i])
    }

    val result = StringBuilder()
    for (c in baseStr) {
        result.append(if (parent.containsKey(c)) find(c) else c)
    }

    return result.toString()
}