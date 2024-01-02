package appmilla.composablepresenter.counter.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import counter.CircuitCounter
import counter.CircuitCounterScreen
import counter.Counter
import counter.CounterViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val counterViewModel by viewModel<CounterViewModel>()

        setContent {
            MaterialTheme {
                Box(Modifier.fillMaxSize()) {
                    Column(
                        Modifier
                            .align(Alignment.Center)
                            .padding(32.dp), // Add padding around the entire column for better spacing from edges.
                    ) {
                        val circuitCounterState by counterViewModel.circuitCounterPresenter.collectAsState()
                        CircuitCounter(circuitCounterState)

                        Spacer(modifier = Modifier.height(32.dp)) // Space between CircuitCounter and Counter

                        val counterState by counterViewModel.counterPresenter.collectAsState()
                        Counter(counterState) { event -> counterViewModel.take(event) }
                    }
                }
            }
        }

        /*
        setContent {
            MaterialTheme {
                Box(Modifier.fillMaxSize()) {
                    Column(Modifier.align(Alignment.Center)) {
                        val circuitCounterState by counterViewModel.circuitCounterPresenter.collectAsState()
                        CircuitCounter(circuitCounterState)

                        val counterState by counterViewModel.counterPresenter.collectAsState()
                        Counter(counterState) { event -> counterViewModel.take(event) }
                    }
                }
            }
        }*/
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    CircuitCounter(CircuitCounterScreen.State(0))
}
