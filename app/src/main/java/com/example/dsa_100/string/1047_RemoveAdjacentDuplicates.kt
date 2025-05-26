package com.example.dsa_100.string

import java.util.Stack

fun removeDuplicates(s: String): String {
    val stack = Stack<Char>()
    for (i in s.indices) {
        if (stack.isEmpty() || stack.peek() != s[i]) {
            stack.push(s[i])
        } else {
            stack.pop()
        }
    }

    val result = StringBuilder()
    while (!stack.isEmpty()) {
        result.append(stack.peek())
        stack.pop()
    }
    return result.reversed().toString()
}

fun main() {
    val s = "abbaca"
    println(removeDuplicates(s))

}
