package com.example.dsa_100.tree

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun main(): Unit = runBlocking {
    val flow = flow {
        emit(1)
        emit(2)
        throw RuntimeException("Error occurred")
    }


    flow.catch {
        emit(3)
        println("Caught exception: ${it.message}")
    }.collect {
        println(it)
    }


}
