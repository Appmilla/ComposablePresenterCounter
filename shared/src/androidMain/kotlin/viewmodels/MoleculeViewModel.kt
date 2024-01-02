package viewmodels

import androidx.compose.ui.platform.AndroidUiDispatcher
import kotlinx.coroutines.CoroutineScope
import androidx.lifecycle.ViewModel as AndroidXViewModel
import androidx.lifecycle.viewModelScope as androidXViewModelScope

actual open class MoleculeViewModel actual constructor(scope: CoroutineScope?) : AndroidXViewModel() {
    actual val viewModelScope: CoroutineScope = scope ?: androidXViewModelScope
    actual val moleculeScope = CoroutineScope(viewModelScope.coroutineContext + AndroidUiDispatcher.Main)
    /*
    init {
        viewModelScope.launch {
            performSetup()
        }
    }*/

    actual override fun onCleared() {
        super.onCleared()
    }

    protected actual open fun performSetup() {
        /* Perform any setup here rather than in init block */
    }
}
