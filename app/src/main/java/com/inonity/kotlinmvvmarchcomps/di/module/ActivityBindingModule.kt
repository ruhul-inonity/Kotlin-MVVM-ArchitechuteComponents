package com.inonity.kotlinmvvmarchcomps.di.module

import androidx.lifecycle.ViewModelProvider
import com.inonity.kotlinmvvmarchcomps.ui.MainActivity
import com.inonity.kotlinmvvmarchcomps.di.ActivityScoped
import com.inonity.kotlinmvvmarchcomps.ui.HomeModule
import com.inonity.kotlinmvvmarchcomps.util.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by ruhul on 16,May,2019
 */

@Module
internal abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = [HomeModule::class])
    internal abstract fun bindMainActivity(): MainActivity
}