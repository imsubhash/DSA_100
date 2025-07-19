package com.example.dsa_100.tree

import android.util.Log
import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

suspend fun fetchUser(): String {
    delay(1000)
    return "User"
}

suspend fun fetchPosts(): String {
    delay(1500)
    return "Posts"
}

fun main() = jobsCancel()

private fun jobsCancel() {
    val job = GlobalScope.launch(Dispatchers.Default) {
        repeat(5) {
            println("Still in Use...")
            delay(1000L)
        }
    }

    runBlocking {
        delay(2000L)
        job.cancel()
        println("Main Thread is Continue...")
    }
}