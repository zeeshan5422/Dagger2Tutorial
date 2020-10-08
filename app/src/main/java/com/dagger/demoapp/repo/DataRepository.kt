package com.dagger.demoapp.repo

class DataRepository constructor(
    val networkRepository: NetworkRepository,
    val cacheRepository: CacheRepository
) {
    var string: String? = null
}