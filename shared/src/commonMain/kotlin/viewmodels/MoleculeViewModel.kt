package viewmodels

import kotlinx.coroutines.CoroutineScope

/**
 * Base class for Molecule ViewModels based on KaMPKit.
 * The molecule scope is used to setup the MonotonicFrameClock for each platform
 */
expect open class MoleculeViewModel(scope: CoroutineScope? = null) {
    val viewModelScope: CoroutineScope
    val moleculeScope: CoroutineScope

    protected open fun onCleared()
    protected open fun performSetup()
}
