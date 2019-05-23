package com.inonity.kotlinmvvmarchcomps.data.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Flowable
import io.reactivex.Maybe
import javax.inject.Inject

/**
 * Created by ruhul on 19,May,2019
 */
@Dao
interface NewsDao {

    @Query("SELECT * FROM News ORDER BY time ASC")
    fun getAllNews(): Maybe<List<NewsEntity>>

    @Query("SELECT * FROM News WHERE id = :newsId")
    fun getNewsById(newsId: Int): Flowable<NewsEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNews(news: NewsEntity)
}