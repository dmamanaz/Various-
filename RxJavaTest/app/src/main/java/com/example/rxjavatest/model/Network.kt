package com.example.rxjavatest.model

import com.example.rxjavatest.ViewContract
import com.example.rxjavatest.presenter.PresenterContract
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


import kotlin.collections.ArrayList

class Network {

    fun initRetrofit(listener: PresenterContract) {

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.androidhive.info/json/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        val apiInterface = retrofit.create(ApiInterface::class.java)

        apiInterface.getMovies()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<ArrayList<MoviesPojo>> {
                override fun onComplete() {

                }

                override fun onSubscribe(d: Disposable) {

                }

                override fun onNext(t: ArrayList<MoviesPojo>) {
                    //assignment send the data to the adapter
                    listener.getDataFromNetwork(t)
                }

                override fun onError(e: Throwable) {
                    e.message?.let {
                        listener.onError(it)
                    }
                }

            })


    }
}