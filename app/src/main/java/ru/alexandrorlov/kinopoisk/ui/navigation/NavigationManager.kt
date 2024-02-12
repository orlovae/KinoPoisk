package ru.alexandrorlov.kinopoisk.ui.navigation

import androidx.navigation.NamedNavArgument
import base.UiNavCommand
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow

internal class NavigationManager {
    private val _sharedFlow =
        MutableSharedFlow<UiNavCommand>(extraBufferCapacity = 1)
    val sharedFlow = _sharedFlow.asSharedFlow()

    fun navigateTo(uiNavCommand: UiNavCommand) {
        _sharedFlow.tryEmit(uiNavCommand)
    }

    fun navigateBack() {
        _sharedFlow.tryEmit(object : UiNavCommand {
            override val arguments: List<NamedNavArgument> = listOf()
            override val destination: String = "OnBack"
        })
    }
}
