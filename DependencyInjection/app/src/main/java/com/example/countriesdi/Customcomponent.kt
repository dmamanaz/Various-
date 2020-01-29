package com.example.countriesdi

import dagger.Component
import javax.inject.Singleton

@Component(modules = [NetworkModule::class])
@Singleton
interface Customcomponent {
    fun inject(activity: MainActivity)
}