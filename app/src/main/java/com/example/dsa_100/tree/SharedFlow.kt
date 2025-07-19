import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun main() = runBlocking {

    val sharedFlow = MutableSharedFlow<Int>()  // default: no replay, no buffer

    // Collector 1
    launch {
        sharedFlow.collect { value ->
            println("Collector 1 received: $value")
        }
    }

    // Collector 2
    launch {
        sharedFlow.collect { value ->
            println("Collector 2 received: $value")
        }
    }

    // Delay to ensure collectors are active before emission
    delay(100)

    // Emitter
    launch {
        repeat(3) { i ->
            println("Emitting: $i")
            sharedFlow.emit(i)
        }
    }

    // Give enough time for collectors to receive
    delay(1000)
}
