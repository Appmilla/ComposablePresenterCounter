package counter

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.unit.dp
import core.UiEvent

@Composable
fun Counter(state: CounterScreen.State, modifier: Modifier = Modifier, onEvent: (UiEvent) -> Unit) {
    val color = if (state.count >= 0) Color.Unspecified else MaterialTheme.colorScheme.error
    Box(modifier = modifier) { // Apply the passed modifier to the root Box
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                text = "Count: ${state.count}",
                style = MaterialTheme.typography.displayLarge,
                color = color,
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                onClick = { onEvent(CounterScreen.CounterEvent.Increment) },
            ) {
                Icon(rememberVectorPainter(Icons.Filled.Add), "Increment")
            }
            Button(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                onClick = { onEvent(CounterScreen.CounterEvent.Decrement) },
            ) {
                Icon(rememberVectorPainter(Remove), "Decrement")
            }
        }
    }
}