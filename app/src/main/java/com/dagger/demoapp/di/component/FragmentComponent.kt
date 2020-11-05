package com.dagger.demoapp.di.component

import com.dagger.demoapp.di.module.FragmentModule
import com.dagger.demoapp.di.scope.FragmentScope
import com.dagger.demoapp.ui.ApplicationFragment
import com.dagger.demoapp.ui.AssetsFragment
import com.dagger.demoapp.ui.FinancialsFragment
import dagger.BindsInstance
import dagger.Subcomponent
import javax.inject.Named


@FragmentScope
@Subcomponent(modules = [FragmentModule::class])
interface FragmentComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(@Named("DAGGER_COUNT") @BindsInstance count: String): FragmentComponent
    }

    fun inject(fragment: ApplicationFragment)

    fun inject(fragment: FinancialsFragment)

    fun inject(fragment: AssetsFragment)
}