package ru.gendalf13666.mycourses.Application

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext
import ru.gendalf13666.mycourses.Di.Di

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        GlobalContext.startKoin {
            androidContext(applicationContext)
            modules(
                listOf(
                    Di.viewModelModule(),
                    Di.useCasesModule(),
                    Di.repositoryModule()
                )
            )
        }
    }
}
