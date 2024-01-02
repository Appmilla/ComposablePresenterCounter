// Copyright (C) 2022 Slack Technologies, LLC
// SPDX-License-Identifier: Apache-2.0
package counter

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import core.CircuitUiEvent
import core.CircuitUiState
import core.Screen

@Composable
fun CircuitCounterPresenter(): CircuitCounterScreen.State {
    var count by remember { mutableStateOf(0) }

    return CircuitCounterScreen.State(count) { event ->
        when (event) {
            is CircuitCounterScreen.CounterEvent.Increment -> count++
            is CircuitCounterScreen.CounterEvent.Decrement -> count--
        }
    }
}

interface CircuitCounterScreen : Screen {
    data class State(
        val count: Int,
        val eventSink: (CounterEvent) -> Unit = {},
    ) : CircuitUiState

    sealed interface CounterEvent : CircuitUiEvent {
        data object Increment : CounterEvent

        data object Decrement : CounterEvent
    }
}
