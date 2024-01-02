package core

import androidx.compose.runtime.Immutable

/**
 * Marker interface for all UiEvent types.
 *
 * Events in Circuit should generally reflect user interactions with the UI. They are mediated by a
 * `Presenter` and may or may not influence the current [state][CircuitUiState].
 *
 * **Circuit event types are annotated as [@Immutable][Immutable] and should only use immutable
 * properties.**
 *
 * ## Testing
 *
 * To test events flowing from a UI, consider using `TestEventSink` from Circuit's test artifact.
 */
@Immutable public interface UiEvent
