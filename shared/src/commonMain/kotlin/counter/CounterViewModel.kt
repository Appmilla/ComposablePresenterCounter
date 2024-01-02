package counter

import app.cash.molecule.RecompositionMode
import app.cash.molecule.launchMolecule
import viewmodels.MoleculeViewModel

class CounterViewModel : MoleculeViewModel() {
    val circuitCounterPresenter = moleculeScope.launchMolecule(mode = RecompositionMode.ContextClock) {
        CircuitCounterPresenter()
    }
}
