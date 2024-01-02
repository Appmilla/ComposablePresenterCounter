package counter

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import core.Screen
import core.UiEvent
import core.UiState

@Composable
fun CounterPresenter(): CounterScreen.State {
    var count by remember { mutableStateOf(0) }

    return CounterScreen.State(count) { event ->
        when (event) {
            is CounterScreen.Event.Increment -> count++
            is CounterScreen.Event.Decrement -> count--
        }
    }
}

interface CounterScreen : Screen {
    data class State(
        val count: Int,
        val eventSink: (Event) -> Unit = {},
    ) : UiState

    sealed interface Event : UiEvent {
        data object Increment : Event

        data object Decrement : Event
    }
}
