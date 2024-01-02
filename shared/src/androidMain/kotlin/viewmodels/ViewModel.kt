package viewmodels

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import androidx.lifecycle.ViewModel as AndroidXViewModel
import androidx.lifecycle.viewModelScope as androidXViewModelScope

actual open class ViewModel actual constructor(scope: CoroutineScope?) : AndroidXViewModel() {
    actual val viewModelScope: CoroutineScope = scope ?: androidXViewModelScope

    init {
        viewModelScope.launch {
            performSetup()
        }
    }

    actual override fun onCleared() {
        super.onCleared()
    }

    protected actual open fun performSetup() {
        /* Perform any setup here rather than in init block */
    }
}
