package com.example.dsa_100.tree

import kotlinx.coroutines.*

fun main() = runBlocking {
    val job = launch {
        try {
            repeat(10) {
                println("Coroutine is running: $it")
                delay(500)
            }
        } catch (e: CancellationException) {
            println("Coroutine cancelled: ${e.message}")
        }
    }

    delay(1500)
    job.cancel()
    job.join()
    println("Coroutine completed")
}