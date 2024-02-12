package ru.alexandrorlov.kinopoisk.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import ru.alexandrorlov.kinopoisk.R
import ru.alexandrorlov.kinopoisk.ui.bottombar.BottomNavItem
import ru.alexandrorlov.kinopoisk.ui.navigation.BottomNavigationBar
import ru.alexandrorlov.kinopoisk.ui.navigation.NavigationGraph

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun MainScreen(
    navController: NavHostController,
) {
//    val state by viewModel.state.collectAsState()
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    Scaffold(
        bottomBar = {
            BottomBar(
                navBackStackEntry = navBackStackEntry,
                navController = navController,
            )
        },
        contentColor = MaterialTheme.colorScheme.secondary,
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(dimensionResource(R.dimen.medium_padding)),
        ) {
            NavigationGraph(navController = navController)
        }
    }
}

@Composable
fun BottomBar(
    navBackStackEntry: NavBackStackEntry?,
    navController: NavHostController,
) {
    navBackStackEntry?.destination?.route
    if (navBackStackEntry?.destination?.route == BottomNavItem.Popular.screenRoot ||
        navBackStackEntry?.destination?.route == BottomNavItem.Favourites.screenRoot
    ) {
        BottomNavigationBar(navController = navController)
    }
}
