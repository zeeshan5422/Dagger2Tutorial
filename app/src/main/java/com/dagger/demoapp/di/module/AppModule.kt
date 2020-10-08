package com.dagger.demoapp.di.module

import android.app.Application
import android.content.Context
import com.dagger.demoapp.di.scope.AppScope
import com.dagger.demoapp.models.DemoDatabase
import com.dagger.demoapp.repo.CacheRepository
import com.dagger.demoapp.repo.DataRepository
import com.dagger.demoapp.repo.DemoActivitymanager
import com.dagger.demoapp.repo.NetworkRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object AppModule {

    @Provides
    @AppScope
    fun provideContext(application: Application): Context {
        return application.applicationContext
    }

    @Provides
    @AppScope
    fun provideDataRepository(
        networkRepo: NetworkRepository,
        cacheRepo: CacheRepository
    ): DataRepository {
        return DataRepository(networkRepository = networkRepo, cacheRepository = cacheRepo)
    }

    @Provides
    @AppScope
    fun provideNetworkRepository(): NetworkRepository {
        return NetworkRepository("Pass Network Repository Instance instead of string instance")
    }

    @Provides
    @AppScope
    fun provideCacheRepository(demoDatabase: DemoDatabase): CacheRepository {
        return CacheRepository(demoDatabase)
    }

    /*@Provides
    @AppScope
    fun provideDemoDatabase(): DemoDatabase {
        return DemoDatabase()
    }*/

    @Provides
    fun provideDemoActivityManager(): DemoActivitymanager {
        return DemoActivitymanager()
    }

}