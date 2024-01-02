import Foundation
import SwiftUI
import Shared

struct CounterView: View {
    
    @ObservedObject
    var presenter = SwiftCounterPresenter()

    var body: some View {
        NavigationView {
            VStack(alignment: .center) {
                Text("Count \(presenter.state?.count ?? 0)")
                    .font(.system(size: 36))
                HStack(spacing: 10) {
                    Button(action: {
                        presenter.take(CounterScreenCounterEventDecrement.shared)
                    }) {
                        Text("-")
                            .font(.system(size: 36, weight: .black, design: .monospaced))
                    }
                        .padding()
                        .foregroundColor(.white)
                        .background(Color.blue)
                    Button(action: {
                        presenter.take(CounterScreenCounterEventIncrement.shared)
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
            .navigationBarTitle("Separated")
        }
    }
}
