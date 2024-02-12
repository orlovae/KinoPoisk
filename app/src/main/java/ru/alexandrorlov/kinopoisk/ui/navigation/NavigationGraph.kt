package ru.alexandrorlov.kinopoisk.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import ru.alexandrorlov.kinopoisk.ui.bottombar.BottomNavItem
import ru.alexandrorlov.kinopoisk.ui.details.DetailScreen
import ru.alexandrorlov.kinopoisk.ui.favorites.FavoritesScreen
import ru.alexandrorlov.kinopoisk.ui.popular.PopularScreen
import ru.alexandrorlov.kinopoisk.ui.util.UiConstant.MOVIE_ID
import ru.alexandrorlov.kinopoisk.ui.util.UiConstant.NAV_TO_DETAIL_MOVIE

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomNavItem.Popular.screenRoot,
    ) {
        composable(
            route = BottomNavItem.Popular.screenRoot,
        ) {
            PopularScreen(
                navController = navController,
            )
        }
        composable(
            route = BottomNavItem.Favourites.screenRoot,
        ) {
            FavoritesScreen(
                navController = navController,
            )
        }

        composable(
            route = "$NAV_TO_DETAIL_MOVIE/{$MOVIE_ID}",
            arguments = listOf(
                navArgument(MOVIE_ID) { type = NavType.IntType },
            ),
        ) {
            val movieId = it.arguments?.getInt(MOVIE_ID) ?: 0
            DetailScreen(
                navController = navController,
                idMovie = movieId,
            )
        }
    }
}
