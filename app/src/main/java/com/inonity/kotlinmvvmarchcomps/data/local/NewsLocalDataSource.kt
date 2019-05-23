package com.inonity.kotlinmvvmarchcomps.data.local

import com.inonity.kotlinmvvmarchcomps.data.local.room.CommentDao
import com.inonity.kotlinmvvmarchcomps.data.local.room.CommentEntity
import com.inonity.kotlinmvvmarchcomps.data.local.room.NewsDao
import com.inonity.kotlinmvvmarchcomps.data.local.room.NewsEntity
import com.inonity.kotlinmvvmarchcomps.data.repository.NewsDataSource
import dagger.Provides
import io.reactivex.Flowable
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by ruhul on 21,May,2019
 */


@Singleton
class NewsLocalDataSource @Inject constructor(
    private val newsDao: NewsDao,
    private val commentDao: CommentDao
) : NewsDataSource {

    override fun getAllNews(): Flowable<List<NewsEntity>> {
        return newsDao.getAllNews().toFlowable()
    }

    override fun getAllComments(newsId: Int): Flowable<List<CommentEntity>> {
        return commentDao.getAllCommentByNewsId(newsId).toFlowable()
    }

    override fun saveAllNews(news: List<NewsEntity>) {
        news.map { newsDao.insertNews(it) }
    }

    override fun saveAllComments(comments: List<CommentEntity>) {
        comments.map { commentDao.insertComment(it) }
    }

    override fun refreshNews() {
    }

    override fun refreshComments() {
    }
}