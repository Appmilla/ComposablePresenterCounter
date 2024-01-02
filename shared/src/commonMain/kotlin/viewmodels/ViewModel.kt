package viewmodels

import kotlinx.coroutines.CoroutineScope

expect open class ViewModel constructor(scope: CoroutineScope? = null) {
    val viewModelScope: CoroutineScope

    protected open fun onCleared()
    protected open fun performSetup()
}
