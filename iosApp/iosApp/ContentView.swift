import SwiftUI
import Shared

struct ContentView: View {
    var body: some View {
        NavigationView {
            VStack {
                CircuitCounterView()
                    .padding(.bottom, 20) // Spacing between the two counters
                
                Divider() // Optional: Adds a visual separation between the two counters
                
                CounterView() // Your second counter view goes here
            }
            //.navigationBarTitle("Counters")
        }
    }
}

/*
struct ContentView: View {
    var body: some View {
        CircuitCounterView()
    }
}*/

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
