package com.inonity.kotlinmvvmarchcomps.di.module

import android.app.Application
import android.content.Context
import com.inonity.kotlinmvvmarchcomps.MyApplication
import com.inonity.kotlinmvvmarchcomps.di.qualifier.ApplicationContext
import dagger.Binds
import dagger.Module

/**
 * Created by ruhul on 16,May,2019
 */

@Module
abstract class AppModule {
    @Binds
    @ApplicationContext
    abstract fun bindApplicationContext(application: MyApplication): Context

    @Binds
    abstract fun bindApplication(application: MyApplication): Application
}