package com.example.rxjavatest.presenter

import android.service.autofill.Dataset
import com.example.rxjavatest.ViewContract
import com.example.rxjavatest.model.MoviesPojo

interface PresenterContract {
    fun bindView(viewContract: ViewContract)
    fun unBindView()
    fun initRetrofit()
    fun getDataFromNetwork(dataSet: ArrayList<MoviesPojo>)
    fun onError(errorMessage : String)
}