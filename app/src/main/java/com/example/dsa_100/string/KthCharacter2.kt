package com.example.dsa_100.string


//StringBuilder: Memory limit exceeded

fun kthCharacter2(k: Long, operations: IntArray): Char {
    val sb = StringBuilder("a")
    for (op in operations) {
        if (op == 0) {
            sb.append(sb)
        } else {
            val shifted = StringBuilder()
            for (c in sb) {
                shifted.append(if (c == 'z') 'a' else c + 1)
            }
            sb.append(shifted)
        }
        if (sb.length >= k) break
    }
    return sb[k.toInt() - 1]
}

//Bitwise: Accepted
fun kthCharacter2Final(k: Long, operations: IntArray): Char {
    var res = 0
    var index = k - 1
    for (i in 0 until operations.size.coerceAtMost(60)) {
        if ((index shr i) and 1L == 1L) {
            res += operations[i]
        }
    }
    return ('a'.code + (res % 26)).toChar()
}
