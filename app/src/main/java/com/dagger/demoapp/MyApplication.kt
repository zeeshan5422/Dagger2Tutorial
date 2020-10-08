package com.dagger.demoapp

import android.app.Application
import com.dagger.demoapp.di.component.DaggerAppComponent

class MyApplication : Application() {

    val appComponent by lazy { DaggerAppComponent.factory().create() }

    override fun onCreate() {
        super.onCreate()
    }

}