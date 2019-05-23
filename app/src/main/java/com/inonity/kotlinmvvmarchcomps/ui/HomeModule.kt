package com.inonity.kotlinmvvmarchcomps.ui

import com.inonity.kotlinmvvmarchcomps.di.FragmentScoped
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by ruhul on 22,May,2019
 */

@Module
abstract class HomeModule {

    @FragmentScoped
    @ContributesAndroidInjector
    abstract fun bindHomeFragment(): HomeFragment
}