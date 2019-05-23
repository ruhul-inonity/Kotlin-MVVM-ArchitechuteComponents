package com.inonity.kotlinmvvmarchcomps.data.remote

import com.inonity.kotlinmvvmarchcomps.data.local.room.CommentEntity
import com.inonity.kotlinmvvmarchcomps.data.local.room.NewsEntity
import com.inonity.kotlinmvvmarchcomps.data.repository.NewsDataSource
import io.reactivex.Flowable
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by ruhul on 21,May,2019
 */

@Singleton
class NewsRemoteDataSource @Inject constructor(
    private val newsService: NewsService
) : NewsDataSource {

    override fun getAllNews(): Flowable<List<NewsEntity>> {
        return newsService.getTopNewsIds()
            .flatMap { newsIds ->
                Flowable.fromIterable(newsIds)
                    .take(10)
                    .flatMap { newsId ->
                        newsService.getNews(newsId)
                    }.toList().toFlowable()
            }
    }

    override fun getAllComments(newsId: Int): Flowable<List<CommentEntity>> {
        return newsService.getNews(newsId)
            .flatMap { news ->
                Flowable.fromIterable(news.commentIds)
                    .take(10)
                    .flatMap { commentId ->
                        newsService.getComment(commentId)
                    }.toList().toFlowable()
            }
    }

    override fun saveAllNews(news: List<NewsEntity>) {
    }

    override fun saveAllComments(comments: List<CommentEntity>) {
    }

    override fun refreshNews() {
    }

    override fun refreshComments() {
    }
}