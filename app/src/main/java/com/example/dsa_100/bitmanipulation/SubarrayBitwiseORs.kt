package com.example.dsa_100.bitmanipulation

fun subarrayBitwiseORs(arr: IntArray): Int {
    var ans = hashSetOf<Int>()
    var cur = hashSetOf<Int>()
    cur.add(0)

    for (x in arr) {
        val cur2 = hashSetOf<Int>()
        for (y in cur) {
            cur2.add(x or y)
        }
        cur2.add(x)
        cur = cur2
        ans.addAll(cur)
    }
    return ans.size
}

fun main() {
    val arr = intArrayOf(1, 2, 4)
    println(subarrayBitwiseORs(arr))
}