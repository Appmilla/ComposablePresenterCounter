import Foundation
import SwiftUI
import Shared

struct CircuitCounterView: View {
    
    @ObservedObject
    var presenter = SwiftCircuitCounterPresenter()

    var body: some View {
        NavigationView {
            VStack(alignment: .center) {
                Text("Count \(presenter.state?.count ?? 0)")
                    .font(.system(size: 36))
                HStack(spacing: 10) {
                    Button(action: {
                        presenter.state?.eventSink(CircuitCounterScreenCounterEventDecrement.shared)
                    }) {
                        Text("-")
                            .font(.system(size: 36, weight: .black, design: .monospaced))
                    }
                        .padding()
                        .foregroundColor(.white)
                        .background(Color.blue)
                    Button(action: {
                        presenter.state?.eventSink(CircuitCounterScreenCounterEventIncrement.shared)
                    }) {
                        Text("+")
                            .font(.system(size: 36, weight: .black, design: .monospaced))
                    }
                        .padding()
                        .foregroundColor(.white)
                        .background(Color.blue)
                }
            }
            .task {
                await presenter.activate()
            }
            .navigationBarTitle("Counter")
        }
    }
}

