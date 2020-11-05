package com.dagger.demoapp.di.component

import com.dagger.demoapp.di.module.ActivityModule
import com.dagger.demoapp.di.module.ActivitySubComponent
import com.dagger.demoapp.di.module.AppModule
import com.dagger.demoapp.di.scope.ActivityScope
import com.dagger.demoapp.di.scope.AppScope
import com.dagger.demoapp.ui.ApplicationFragment
import com.dagger.demoapp.ui.DashboardFragment
import com.dagger.demoapp.ui.MainActivity
import com.dagger.demoapp.ui.SettingsActivity
import dagger.Component
import dagger.Subcomponent


@ActivityScope
@Subcomponent(modules = [ActivityModule::class, ActivitySubComponent::class])
interface ActivityComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): ActivityComponent
    }

    fun inject(mainActivity: MainActivity)

    fun inject(dashboardFragment: DashboardFragment)

    fun inject(applicationFragment: ApplicationFragment)

    fun applicationFragmentComponent(): FragmentComponent.Factory

}