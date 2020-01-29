package com.example.rxjavatest.presenter

import com.example.rxjavatest.ViewContract
import com.example.rxjavatest.model.MoviesPojo
import com.example.rxjavatest.model.Network

class Presenter : PresenterContract{
    override fun onError(errorMessage: String) {
        view?.onError(errorMessage)
    }

    var view : ViewContract? = null

    override fun bindView(viewContract: ViewContract) {
        view = viewContract
    }

    override fun unBindView() {
        view = null
    }

    override fun initRetrofit() {
       val network = Network()
        network.initRetrofit(this)
    }

    override fun getDataFromNetwork(dataSet: ArrayList<MoviesPojo>) {
        view?.passData(dataSet)
    } // implements the methods defined in the contract
}