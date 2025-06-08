package com.example.dsa_100.string

fun robotWithString(s: String): String {
    val cnt = IntArray(26)
    for (c in s) {
        cnt[c - 'a']++
    }

    val stack = ArrayDeque<Char>()
    val res = StringBuilder()
    var minCharacter = 'a'
    for (c in s) {
        stack.add(c)
        cnt[c - 'a']--
        while (minCharacter <= 'z' && cnt[minCharacter - 'a'] == 0) {
            minCharacter++
        }
        while (stack.isNotEmpty() && stack.last() <= minCharacter) {
            res.append(stack.removeLast())
        }
    }

    return res.toString()
}