package counter

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import core.Screen
import core.UiEvent
import core.UiState
import kotlinx.coroutines.flow.Flow

@Composable
fun CounterPresenter(events: Flow<UiEvent>): CounterScreen.State {
    var count by remember { mutableStateOf(0) }

    // Handle UI events.
    LaunchedEffect(Unit) {
        events.collect { event ->
            when (event) {
                is CounterScreen.CounterEvent.Increment -> count++
                is CounterScreen.CounterEvent.Decrement -> count--
            }
        }
    }

    return CounterScreen.State(count = count)
}

interface CounterScreen : Screen {
    data class State(
        val count: Int,
    ) : UiState

    sealed interface CounterEvent : UiEvent {
        data object Increment : CounterEvent

        data object Decrement : CounterEvent
    }
}
