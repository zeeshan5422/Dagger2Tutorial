package com.dagger.demoapp.di.scope

import java.lang.annotation.Documented
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import javax.inject.Scope

@Documented
@Scope
@Retention(value = RetentionPolicy.RUNTIME)
annotation class FragmentScope