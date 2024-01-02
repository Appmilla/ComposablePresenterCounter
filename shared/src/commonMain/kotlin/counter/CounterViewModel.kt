package counter

import app.cash.molecule.RecompositionMode
import app.cash.molecule.launchMolecule
import viewmodels.MoleculeViewModel

class CounterViewModel : MoleculeViewModel() {
    val counterPresenter = moleculeScope.launchMolecule(mode = RecompositionMode.ContextClock) {
        CounterPresenter()
    }
}