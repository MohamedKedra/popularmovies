package com.task.mkedra.popularmovies

import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.task.mkedra.popularmovies.Data.Utils
import com.task.mkedra.popularmovies.UI.Main.MainCallback
import com.task.mkedra.popularmovies.UI.Main.MainPresenter
import org.junit.Before
import org.junit.Test

class MainTests {

    lateinit var presenter : MainPresenter
    lateinit var viewCallback: MainCallback.ViewCallback

    @Before
    fun setup(){

        presenter = MainPresenter()
        viewCallback = mock()
        presenter.setView(viewCallback)
    }

    @Test
    fun getTypeWithPopularMovies(){

        presenter.sendType(Utils.Popular)
        verify(viewCallback).receiveMovies(any())
    }

}