package counter

import app.cash.molecule.RecompositionMode
import app.cash.molecule.launchMolecule
import core.UiEvent
import kotlinx.coroutines.flow.MutableSharedFlow
import viewmodels.MoleculeViewModel

class CounterViewModel : MoleculeViewModel() {
    val circuitCounterPresenter = moleculeScope.launchMolecule(mode = RecompositionMode.ContextClock) {
        CircuitCounterPresenter()
    }

    // Events have a capacity large enough to handle simultaneous UI events, but
    // small enough to surface issues if they get backed up for some reason.
    private val events = MutableSharedFlow<UiEvent>(extraBufferCapacity = 20)

    val counterPresenter = moleculeScope.launchMolecule(mode = RecompositionMode.ContextClock) {
        CounterPresenter(events)
    }

    fun take(event: UiEvent) {
        if (!events.tryEmit(event)) {
            error("Event buffer overflow.")
        }
    }
}
