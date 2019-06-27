package com.task.mkedra.popularmovies.DI.Component

import com.task.mkedra.popularmovies.DI.App
import com.task.mkedra.popularmovies.DI.Modules.ActivitiesModule
import com.task.mkedra.popularmovies.DI.Modules.AppModule
import com.task.mkedra.popularmovies.DI.Modules.ClientModule
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, AppModule::class, ActivitiesModule::class, ClientModule::class])
interface AppComponent {

    fun inject(app: App)
}