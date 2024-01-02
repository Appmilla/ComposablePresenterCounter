package appmilla.composablepresenter.counter.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import counter.Counter
import counter.CounterScreen
import counter.CounterViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val counterViewModel by viewModel<CounterViewModel>()

        setContent {
            MaterialTheme {
                val counterState by counterViewModel.counterPresenter.collectAsState()
                Counter(counterState)
            }
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    Counter(CounterScreen.State(0))
}
