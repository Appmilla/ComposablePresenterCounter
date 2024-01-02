import Foundation
import Shared

class SwiftCircuitCounterPresenter: ObservableObject {
    
    var viewModel: CounterViewModel = KotlinDependencies.shared.getCounterViewModel()
    
    @Published
    private(set) var state: CircuitCounterScreenState? = nil

    @MainActor
    func activate() async {
        for await state in viewModel.circuitCounterPresenter {
           
            self.state = state
        }
    }
}
