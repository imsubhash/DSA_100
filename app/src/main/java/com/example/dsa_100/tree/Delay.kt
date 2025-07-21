package com.example.dsa_100.tree

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlin.system.measureTimeMillis


fun main() {
    val time = measureTimeMillis {
        GlobalScope.async {
            delay(1000)
        }
    }
    println("Time: $time ms") // ~0ms
}
