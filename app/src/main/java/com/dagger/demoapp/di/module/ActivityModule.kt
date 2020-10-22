package com.dagger.demoapp.di.module

import com.dagger.demoapp.di.scope.ActivityScope
import com.dagger.demoapp.repo.ActivityManager
import dagger.Module
import dagger.Provides

@Module
class ActivityModule {


    @ActivityScope
    @Provides
    fun provideDemoActivityManager(): ActivityManager {
        return ActivityManager()
    }
}