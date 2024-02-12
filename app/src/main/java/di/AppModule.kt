package di

import network.DetailMovieRepositoryImpl
import network.NetworkApi
import network.TopMovieRepositoryImpl
import network.api.DetailMovieRepository
import network.api.TopMovieRepository
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.Module
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import ru.alexandrorlov.kinopoisk.ui.details.DetailsViewModel
import ru.alexandrorlov.kinopoisk.ui.navigation.NavigationManager
import ru.alexandrorlov.kinopoisk.ui.popular.PopularViewModel

val appModule: Module
    get() =
        module {
            includes(
                networkModule,
                popularModule,
                detailsModule,
                navModule,
            )
        }

val networkModule = module {
    singleOf(NetworkApi::create)
}

val popularModule = module {
    singleOf(::TopMovieRepositoryImpl) {
        bind<TopMovieRepository>()
    }

    viewModelOf(::PopularViewModel)
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