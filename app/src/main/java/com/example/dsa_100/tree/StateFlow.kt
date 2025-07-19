import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun main() = runBlocking {

    val stateFlow = MutableStateFlow<Int>(-1)  // default: no replay, no buffer

    // Collector 1
    launch {
        stateFlow.collect { value ->
            println("Collector 1 received: $value")
        }
    }

    // Collector 2
    launch {
        stateFlow.collect { value ->
            println("Collector 2 received: $value")
        }
    }

    // Delay to ensure collectors are active before emission
    delay(100)

    // Emitter
    launch {
        repeat(3) { i ->
            println("Emitting: $i")
            stateFlow.value = i
            stateFlow.emit(i)
        }
    }

    // Give enough time for collectors to receive
    delay(1000)
}
