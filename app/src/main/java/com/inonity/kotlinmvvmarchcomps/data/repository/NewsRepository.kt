package com.inonity.kotlinmvvmarchcomps.data.repository

import com.inonity.kotlinmvvmarchcomps.data.local.NewsLocalDataSource
import com.inonity.kotlinmvvmarchcomps.data.local.room.CommentEntity
import com.inonity.kotlinmvvmarchcomps.data.local.room.NewsEntity
import com.inonity.kotlinmvvmarchcomps.data.remote.NewsRemoteDataSource
import com.inonity.kotlinmvvmarchcomps.di.qualifier.LocalData
import com.inonity.kotlinmvvmarchcomps.di.qualifier.RemoteData
import io.reactivex.Flowable
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by ruhul on 21,May,2019
 */

@Singleton
class NewsRepository @Inject constructor(
    @LocalData private val localDataSource: NewsLocalDataSource,
    @RemoteData private val remoteDataSource: NewsRemoteDataSource
) : NewsDataSource {
    private var cachedNews = listOf<NewsEntity>()

    private var cacheNewsIsDirty = false

    private var cachedComments: MutableMap<Int, List<CommentEntity>> = mutableMapOf()

    private var cacheCommentsIsDirty = false

    override fun getAllNews(): Flowable<List<NewsEntity>> {

        if (cachedNews.isNotEmpty() && !cacheNewsIsDirty) {
            return Flowable.just(cachedNews)
        }

        val remoteNews = getAndSaveRemoteNews()

        return if (cacheNewsIsDirty) remoteNews else {
            val localNews = getAndCacheLocalNews()
            Flowable.concat(localNews, remoteNews)
        }
    }

    override fun getAllComments(newsId: Int): Flowable<List<CommentEntity>> {
        cachedComments[newsId]?.let { comments ->
            if (comments.isNotEmpty() && !cacheCommentsIsDirty) {
                return Flowable.just(comments)
            }
        }

        val remoteComments = getAndSaveRemoteComments(newsId)

        return if (cacheCommentsIsDirty) remoteComments else {
            val localComments = getAndCacheLocalComments(newsId)
            Flowable.concat(localComments, remoteComments)
        }
    }

    override fun saveAllNews(news: List<NewsEntity>) {
        localDataSource.saveAllNews(news)
        remoteDataSource.saveAllNews(news)
    }

    override fun saveAllComments(comments: List<CommentEntity>) {
        localDataSource.saveAllComments(comments)
        remoteDataSource.saveAllComments(comments)
    }

    override fun refreshNews() {
        cacheNewsIsDirty = true
    }

    override fun refreshComments() {
        cacheCommentsIsDirty = true
    }

    private fun getAndSaveRemoteNews(): Flowable<List<NewsEntity>> {
        return remoteDataSource.getAllNews()
            .doOnNext { news ->
                localDataSource.saveAllNews(news)
                cachedNews = news
            }.doOnComplete {
                cacheNewsIsDirty = false
            }
    }

    private fun getAndCacheLocalNews(): Flowable<List<NewsEntity>> {
        return localDataSource.getAllNews().doOnNext { news -> cachedNews = news }
    }

    private fun getAndSaveRemoteComments(newsId: Int): Flowable<List<CommentEntity>> {
        return remoteDataSource.getAllComments(newsId)
            .doOnNext { comments ->
                localDataSource.saveAllComments(comments)
                cachedComments[newsId] = comments
            }.doOnComplete {
                cacheCommentsIsDirty = false
            }
    }

    private fun getAndCacheLocalComments(newsId: Int): Flowable<List<CommentEntity>> {
        return localDataSource.getAllComments(newsId).doOnNext { comments -> cachedComments[newsId] = comments }
    }

}
