package di

import data.local.DataBaseApi
import data.local.FavoriteMovieRepositoryImpl
import data.local.api.FavoriteMovieRepository
import data.network.DetailMovieRepositoryImpl
import data.network.NetworkApi
import data.network.TopMovieRepositoryImpl
import data.network.api.DetailMovieRepository
import data.network.api.TopMovieRepository
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.Module
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import ru.alexandrorlov.kinopoisk.ui.details.DetailsViewModel
import ru.alexandrorlov.kinopoisk.ui.favorites.FavoriteViewModel
import ru.alexandrorlov.kinopoisk.ui.navigation.NavigationManager
import ru.alexandrorlov.kinopoisk.ui.popular.PopularViewModel

val appModule: Module
    get() =
        module {
            includes(
                networkModule,
                localDataBaseModule,
                popularModule,
                favoritesModule,
                detailsModule,
                navModule,
            )
        }

val networkModule = module {
    singleOf(NetworkApi::create)
}

val localDataBaseModule = module {
    singleOf(DataBaseApi::create)
}

val popularModule = module {
    singleOf(::TopMovieRepositoryImpl) {
        bind<TopMovieRepository>()
    }

    viewModelOf(::PopularViewModel)
}

val favoritesModule = module {
    singleOf(::FavoriteMovieRepositoryImpl) {
        bind<FavoriteMovieRepository>()
    }

    viewModelOf(::FavoriteViewModel)
}

val detailsModule = module {
    singleOf(::DetailMovieRepositoryImpl) {
        bind<DetailMovieRepository>()
    }

    viewModelOf(::DetailsViewModel)
}

val navModule = module {
    singleOf(::NavigationManager)
}
