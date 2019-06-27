package com.task.mkedra.popularmovies.DI.Modules

import com.task.mkedra.popularmovies.Data.Network.ClientApi
import com.task.mkedra.popularmovies.Data.Utils
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class ClientModule {

    @Singleton
    @Provides
    fun getInstance() : ClientApi{

        return Retrofit.Builder()
            .baseUrl(Utils.base)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build().create(ClientApi::class.java)
    }
}