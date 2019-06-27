package com.task.mkedra.popularmovies.DI.Modules

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides


@Module
class AppModule {

    @Provides
    fun getAppContext(application: Application)  : Context{

        return application.applicationContext
    }

}