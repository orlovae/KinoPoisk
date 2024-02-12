package ru.alexandrorlov.kinopoisk.ui.navigation

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import ru.alexandrorlov.kinopoisk.ui.bottombar.BottomNavItem
import ru.alexandrorlov.kinopoisk.ui.theme.TypographyKinopoisk

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        BottomNavItem.Popular,
        BottomNavItem.Favourites,
    )
    BottomNavigation(
        backgroundColor = MaterialTheme.colorScheme.background,
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                icon = { },
                label = {
                    Text(
                        text = stringResource(id = item.titleId),
                        modifier = Modifier,
                        style = MaterialTheme.TypographyKinopoisk.titleBottomBar,
                    )
                },
                selectedContentColor = MaterialTheme.colorScheme.primary,
                unselectedContentColor = MaterialTheme.colorScheme.tertiary,
                alwaysShowLabel = true,
                selected = currentRoute == item.screenRoot,
                onClick = {
                    navController.navigate(item.screenRoot) {
                        navController.graph.startDestinationRoute?.let { screenRoot ->
                            popUpTo(screenRoot) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
            )
        }
    }
}
