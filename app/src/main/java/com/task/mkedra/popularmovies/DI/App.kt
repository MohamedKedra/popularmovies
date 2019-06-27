package com.task.mkedra.popularmovies.DI

import android.app.Activity
import android.app.Application
import com.task.mkedra.popularmovies.DI.Component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class App  : Application(),HasActivityInjector{

    @Inject
    lateinit var dispatching : DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()

        DaggerAppComponent
            .create()
            .inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return dispatching
    }
}