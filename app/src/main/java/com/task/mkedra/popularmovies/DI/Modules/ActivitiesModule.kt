package com.task.mkedra.popularmovies.DI.Modules

import com.task.mkedra.popularmovies.UI.Details.DetailsActivity
import com.task.mkedra.popularmovies.UI.Details.DetailsFragment
import com.task.mkedra.popularmovies.UI.Main.MainActivity
import com.task.mkedra.popularmovies.UI.Main.MainFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivitiesModule {

    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun bindMainActivity() : MainActivity

    @ContributesAndroidInjector(modules = [MainFragmentModule::class])
    abstract fun bindMainFragment() : MainFragment

    @ContributesAndroidInjector(modules = [DetailsActivityModule::class])
    abstract fun bindDetailsActivity() : DetailsActivity

    @ContributesAndroidInjector(modules = [DetailsFragmentModule::class])
    abstract fun bindDetailsFragment() : DetailsFragment
}