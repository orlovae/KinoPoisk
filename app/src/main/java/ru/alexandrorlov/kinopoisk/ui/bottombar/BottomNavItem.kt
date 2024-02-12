package ru.alexandrorlov.kinopoisk.ui.bottombar

import androidx.annotation.StringRes
import ru.alexandrorlov.kinopoisk.R

sealed class BottomNavItem(
    val screenRoot: String,
    @StringRes val titleId: Int,
) {
    data object Popular : BottomNavItem(
        screenRoot = POPULAR,
        titleId = R.string.popular_item_bottombar,
    )

    data object Favourites : BottomNavItem(
        screenRoot = FAVORITES,
        titleId = R.string.favorites_item_bottombar,
    )

    companion object {
        private const val POPULAR = "popular"
        private const val FAVORITES = "favourites"
    }
}
