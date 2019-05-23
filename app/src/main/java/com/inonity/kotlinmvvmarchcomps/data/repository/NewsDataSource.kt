package com.inonity.kotlinmvvmarchcomps.data.repository

import com.inonity.kotlinmvvmarchcomps.data.local.room.CommentEntity
import com.inonity.kotlinmvvmarchcomps.data.local.room.NewsEntity
import dagger.Provides
import io.reactivex.Flowable

/**
 * Created by ruhul on 21,May,2019
 */
interface NewsDataSource {

    fun getAllNews(): Flowable<List<NewsEntity>>

    fun getAllComments(newsId: Int): Flowable<List<CommentEntity>>

    fun saveAllNews(news: List<NewsEntity>)

    fun saveAllComments(comments: List<CommentEntity>)

    fun refreshNews()

    fun refreshComments()
}