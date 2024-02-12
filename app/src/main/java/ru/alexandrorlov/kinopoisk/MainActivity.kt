package ru.alexandrorlov.kinopoisk

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.debounce
import org.koin.android.ext.android.inject
import ru.alexandrorlov.kinopoisk.ui.MainScreen
import ru.alexandrorlov.kinopoisk.ui.navigation.NavigationManager
import ru.alexandrorlov.kinopoisk.ui.theme.KinoPoiskTheme

class MainActivity : ComponentActivity() {
    private val navigationManager by inject<NavigationManager>()

    @OptIn(FlowPreview::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            LaunchedEffect(key1 = Unit) {
                navigationManager.sharedFlow.debounce { 100L }.collect {
                    if (it.destination == "OnBack") {
                        navController.popBackStack()
                    } else {
                        navController.navigate(it.destination)
                    }
                }
            }

            KinoPoiskTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    MainScreen(navController = navController)
                }
            }
        }
    }
}
