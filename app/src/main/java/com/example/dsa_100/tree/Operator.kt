package com.example.dsa_100.tree

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking

fun main() {
    val flow = producer()


    runBlocking {
        flow.collect {
            println("Collected: $it")
        }

        val firstValue = flow.first()
        println("First value: $firstValue")

        val list = flow.toList()
        println("List: $list")
    }
}

private fun producer(): Flow<Int> = flow {
    val list = listOf(1, 2, 3, 4, 5)
    list.forEach { item ->
        delay(1000)
        emit(item)
    }
}