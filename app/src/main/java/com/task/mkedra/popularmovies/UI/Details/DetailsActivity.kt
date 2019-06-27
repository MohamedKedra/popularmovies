package com.task.mkedra.popularmovies.UI.Details

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import com.task.mkedra.popularmovies.Data.Models.Movie
import com.task.mkedra.popularmovies.Data.Utils
import com.task.mkedra.popularmovies.R
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

class DetailsActivity : AppCompatActivity() ,HasSupportFragmentInjector{

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        val movie = intent.extras.getParcelable<Movie>(Utils.Movie)
        supportFragmentManager.beginTransaction().replace(R.id.container,DetailsFragment.getInstance(movie)).commit()
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return dispatchingAndroidInjector
    }
}
