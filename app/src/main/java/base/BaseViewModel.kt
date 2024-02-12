package base

import androidx.lifecycle.ViewModel
import androidx.navigation.NamedNavArgument
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

internal interface UiState

internal interface UiNavCommand {
    val arguments: List<NamedNavArgument>
    val destination: String
}
internal abstract class BaseViewModel<State>(initialState: State) :
    ViewModel()
    where State : UiState {
    private val _state = MutableStateFlow(initialState)
    val state: StateFlow<State>
        get() = _state.asStateFlow()
}
