package com.dagger.demoapp.di.module

import com.dagger.demoapp.di.scope.FragmentScope
import com.dagger.demoapp.repo.ApplicationFragmentManager
import dagger.Module
import dagger.Provides

@Module
class FragmentModule {


    @FragmentScope
    @Provides
    fun provideApplicationFragmentManager(): ApplicationFragmentManager {
        return ApplicationFragmentManager()
    }
}