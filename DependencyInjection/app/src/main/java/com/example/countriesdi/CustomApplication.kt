package com.example.countriesdi

import android.app.Application

class CustomApplication: Application() {
    //this class is used to build component
    lateinit var component: Customcomponent

    override fun onCreate() {
        super.onCreate()
        component = DaggerCustomcomponent.builder().build()
    }
//    fun getCustomComponent(): Customcomponent{
//        return component
//    }

}