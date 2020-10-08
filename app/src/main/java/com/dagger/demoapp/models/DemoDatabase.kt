package com.dagger.demoapp.models

import com.dagger.demoapp.di.scope.AppScope
import javax.inject.Inject

@AppScope
class DemoDatabase @Inject constructor() {
}