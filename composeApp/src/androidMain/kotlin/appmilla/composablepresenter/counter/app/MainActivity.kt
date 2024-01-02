package appmilla.composablepresenter.counter.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import counter.CircuitCounter
import counter.CircuitCounterScreen
import counter.CounterViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val counterViewModel by viewModel<CounterViewModel>()

        setContent {
            MaterialTheme {
                val counterState by counterViewModel.circuitCounterPresenter.collectAsState()
                CircuitCounter(counterState)
            }
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    CircuitCounter(CircuitCounterScreen.State(0))
}
