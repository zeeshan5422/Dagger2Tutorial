package com.dagger.demoapp.di.module

import com.dagger.demoapp.di.component.ActivityComponent
import com.dagger.demoapp.di.component.FragmentComponent
import dagger.Module

@Module(subcomponents = [FragmentComponent::class])
class ActivitySubComponent {
}