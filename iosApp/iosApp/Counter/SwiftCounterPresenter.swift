import Foundation
import Shared

class SwiftCounterPresenter: ObservableObject {
    
    var viewModel: CounterViewModel = KotlinDependencies.shared.getCounterViewModel()
    
    @Published
    private(set) var state: CounterScreenState? = nil

    @MainActor
    func activate() async {
        for await state in viewModel.counterPresenter {
           
            self.state = state
        }
    }
    
    func take(_ event: UiEvent) {
        viewModel.take(event: event)
    }
}
