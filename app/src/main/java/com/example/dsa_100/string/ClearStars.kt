package com.example.dsa_100.string

import java.util.ArrayDeque
import java.util.Deque
class Solution1 {

    fun clearStars(s: String): String {
        val cnt: Array<Deque<Int>> = Array(26) { ArrayDeque<Int>() }
        val arr = s.toCharArray()
        for (i in arr.indices) {
            if (arr[i] != '*') {
                cnt[arr[i] - 'a'].push(i)
            } else {
                for (j in 0 until 26) {
                    if (!cnt[j].isEmpty()) {
                        arr[cnt[j].pop()] = '*'
                        break
                    }
                }
            }
        }

        val ans = StringBuilder()
        for (c in arr) {
            if (c != '*') {
                ans.append(c)
            }
        }
        return ans.toString()
    }
}

fun main() {
    println(Solution1().clearStars("aaba*"))
}