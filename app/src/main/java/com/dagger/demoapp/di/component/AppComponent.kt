package com.dagger.demoapp.di.component

import com.dagger.demoapp.di.module.AppModule
import com.dagger.demoapp.di.module.AppSubComponent
import com.dagger.demoapp.di.scope.AppScope
import com.dagger.demoapp.ui.ApplicationFragment
import com.dagger.demoapp.ui.DashboardFragment
import com.dagger.demoapp.ui.MainActivity
import com.dagger.demoapp.ui.SettingsActivity
import dagger.Binds
import dagger.Component


@AppScope
@Component(modules = [AppModule::class, AppSubComponent::class])
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(): AppComponent
    }

    fun inject(settingsActivity: SettingsActivity)
////
//    fun inject(mainActivity: MainActivity)
//
//    fun inject(dashboardFragment: DashboardFragment)

//    fun inject(applicationFragment: ApplicationFragment)

    fun mainActivityComponent(): ActivityComponent.Factory

}