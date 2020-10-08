package com.dagger.demoapp.di.component

import com.dagger.demoapp.di.module.AppModule
import com.dagger.demoapp.di.scope.AppScope
import com.dagger.demoapp.ui.MainActivity
import com.dagger.demoapp.ui.SettingsActivity
import dagger.Component


@AppScope
@Component(modules = [AppModule::class])
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(): AppComponent
    }

    fun inject(mainActivity: MainActivity)

    fun inject(settingsActivity: SettingsActivity)

}