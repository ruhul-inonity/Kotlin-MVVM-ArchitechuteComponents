package com.inonity.kotlinmvvmarchcomps.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * Created by ruhul on 19,May,2019
 */

@Database(entities = [NewsEntity::class, CommentEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun newsDao(): NewsDao

    abstract fun commentDao(): CommentDao
}