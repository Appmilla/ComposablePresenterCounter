# ComposablePresenterCounter
A Composable Presenter counter example using Molecule &amp; SKIE

A Kotlin Multiplatform app for iOS and Android targets with SwiftUI and Jetpack Compose native views.

Built from the JetBrains KMP web wizard, using:-
* Koin for DI
* Cashapp's Molecule to output a StateFlow from a Composable Presenter
* Touchlab's SKIE to consume the Presenter's StateFlow in SwiftUI

The app is based on the Counter example in Slack Circuit, with a Circuit 
A single 'CounterViewModel' is used as a container to host two composable presenters:-
* Slack Circuit Style presenter with an EventSink in the State object
* Presenter with separate Event Sink and State

The Slack Circuit counter example was used as the starting point for the screens and presenter, hence the inclusion of the original copyright notice.  




