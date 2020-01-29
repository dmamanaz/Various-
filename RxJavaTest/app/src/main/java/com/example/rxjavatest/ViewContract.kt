package com.example.rxjavatest

import com.example.rxjavatest.model.MoviesPojo

interface ViewContract { //defines interaction between the view and the presenter
    //other name for Interface is Contract
    fun onError(errorMessage : String)
    fun passData(dataset : ArrayList<MoviesPojo>)
    fun bindPresenter()
    fun initUI()
}