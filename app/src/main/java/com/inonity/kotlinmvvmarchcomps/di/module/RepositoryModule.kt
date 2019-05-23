package com.inonity.kotlinmvvmarchcomps.di.module

import com.inonity.kotlinmvvmarchcomps.data.local.NewsLocalDataSource
import com.inonity.kotlinmvvmarchcomps.data.remote.NewsRemoteDataSource
import com.inonity.kotlinmvvmarchcomps.data.repository.NewsDataSource
import com.inonity.kotlinmvvmarchcomps.di.qualifier.LocalData
import com.inonity.kotlinmvvmarchcomps.di.qualifier.RemoteData
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

/**
 * Created by ruhul on 16,May,2019
 */

@Module
abstract class RepositoryModule {

    @Singleton
    @Binds
    @LocalData
    abstract fun bindNewsLocalDataSource(newsLocalDataSource: NewsLocalDataSource): NewsDataSource

    @Singleton
    @Binds
    @RemoteData
    abstract fun bindNewsRemoteDataSource(newsRemoteDataSource: NewsRemoteDataSource): NewsDataSource
}