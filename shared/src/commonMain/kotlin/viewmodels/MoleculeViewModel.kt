package viewmodels

import kotlinx.coroutines.CoroutineScope

expect open class MoleculeViewModel constructor(scope: CoroutineScope? = null) {
    val viewModelScope: CoroutineScope
    val moleculeScope: CoroutineScope
    protected open fun onCleared()
    protected open fun performSetup()
}