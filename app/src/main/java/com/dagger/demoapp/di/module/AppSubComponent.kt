package com.dagger.demoapp.di.module

import com.dagger.demoapp.di.component.ActivityComponent
import dagger.Module

@Module(subcomponents = [ActivityComponent::class])
object AppSubComponent {
}