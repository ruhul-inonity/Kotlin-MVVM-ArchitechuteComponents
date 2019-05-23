package com.inonity.kotlinmvvmarchcomps.data.remote

import com.inonity.kotlinmvvmarchcomps.data.local.room.CommentEntity
import com.inonity.kotlinmvvmarchcomps.data.local.room.NewsEntity
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by ruhul on 21,May,2019
 */

interface NewsService {

    @GET("topstories.json")
    fun getTopNewsIds(): Flowable<List<Int>>

    @GET("item/{news_id}.json")
    fun getNews(@Path("news_id") newsId: Int): Flowable<NewsEntity>

    @GET("item/{comment_id}.json")
    fun getComment(@Path("comment_id") commentId: Int): Flowable<CommentEntity>
}