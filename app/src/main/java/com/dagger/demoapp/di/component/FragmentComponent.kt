package com.dagger.demoapp.di.component

import com.dagger.demoapp.di.module.FragmentModule
import com.dagger.demoapp.di.scope.FragmentScope
import com.dagger.demoapp.ui.ApplicationFragment
import com.dagger.demoapp.ui.AssetsFragment
import com.dagger.demoapp.ui.FinancialsFragment
import dagger.Subcomponent


@FragmentScope
@Subcomponent(modules = [FragmentModule::class])
interface FragmentComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): FragmentComponent
    }

    fun inject(fragment: ApplicationFragment)

    fun inject(fragment: FinancialsFragment)

    fun inject(fragment: AssetsFragment)
}