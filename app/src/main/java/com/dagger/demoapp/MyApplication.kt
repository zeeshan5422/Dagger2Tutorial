package com.dagger.demoapp

import android.app.Application
import android.content.Context
import com.dagger.demoapp.di.component.DaggerAppComponent
import javax.inject.Inject
import javax.inject.Named

class MyApplication : Application() {

    val appComponent by lazy { DaggerAppComponent.factory().create() }

    override fun onCreate() {
        super.onCreate()
    }

}