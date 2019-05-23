package com.inonity.kotlinmvvmarchcomps.di.module

import androidx.room.Room
import com.inonity.kotlinmvvmarchcomps.MyApplication
import com.inonity.kotlinmvvmarchcomps.data.local.room.AppDatabase
import com.inonity.kotlinmvvmarchcomps.data.local.room.CommentDao
import com.inonity.kotlinmvvmarchcomps.data.local.room.NewsDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by ruhul on 16,May,2019
 */

@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun provideDatabase(application: MyApplication): AppDatabase {
        return Room.databaseBuilder(application, AppDatabase::class.java, "bl.db").build()
    }

    @Singleton
    @Provides
    fun provideNewsDao(database: AppDatabase): NewsDao = database.newsDao()

    @Singleton
    @Provides
    fun provideCommentDao(database: AppDatabase): CommentDao = database.commentDao()

}