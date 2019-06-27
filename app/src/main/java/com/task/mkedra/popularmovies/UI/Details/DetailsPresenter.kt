package com.task.mkedra.popularmovies.UI.Details

import android.util.Log
import com.task.mkedra.popularmovies.Data.Models.Trailer
import com.task.mkedra.popularmovies.Data.Models.TrailerResponse
import com.task.mkedra.popularmovies.Data.Network.ClientApi
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class DetailsPresenter @Inject constructor()  : DetailsCallback.PresenterCallback {

    lateinit var callback: DetailsCallback.ViewCallback

    @Inject
    lateinit var api: ClientApi

    lateinit var trailers : List<Trailer>

    fun setView(callback : DetailsCallback.ViewCallback){
        Log.d("hhh","---------------------------------------------------------")
        this.callback = callback
    }

    override fun send(id: Int, key: String) {
        api.getTrailers(id,key)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(observer)
    }

    val observer = object : Observer<TrailerResponse> {
        override fun onComplete() {
            Log.d("send",""+trailers.size)
            callback.receiveTrailers(trailers)
        }

        override fun onSubscribe(d: Disposable) {
        }

        override fun onNext(t: TrailerResponse) {
            trailers = ArrayList(t.trailers)
            Log.d("send",""+trailers.size)
        }

        override fun onError(e: Throwable) {
        }
    }
}