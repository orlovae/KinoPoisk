package ru.alexandrorlov.kinopoisk

import android.app.Application
import di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import timber.log.Timber

class Application : Application() {
    override fun onCreate() {
        super.onCreate()
        initTimber()
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@Application)
            androidFileProperties()
            modules(
                appModule,
            )
        }
    }

    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}
