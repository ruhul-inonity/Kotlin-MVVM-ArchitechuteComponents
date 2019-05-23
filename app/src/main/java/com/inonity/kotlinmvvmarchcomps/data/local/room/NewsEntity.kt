package com.inonity.kotlinmvvmarchcomps.data.local.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.inonity.kotlinmvvmarchcomps.util.RoomConverter
import com.inonity.kotlinmvvmarchcomps.util.getRelativeTime

/**
 * Created by ruhul on 19,May,2019
 */

@Entity(tableName = "News")
@TypeConverters(RoomConverter::class)
data class NewsEntity constructor(
    @PrimaryKey
    @ColumnInfo(name = "id")
    @SerializedName("id")
    @Expose
    var id: Int = 0,

    @ColumnInfo(name = "by")
    @SerializedName("by")
    @Expose
    var by: String = "",

    @ColumnInfo(name = "title")
    @SerializedName("title")
    @Expose
    var title: String = "",

    @ColumnInfo(name = "url")
    @SerializedName("url")
    @Expose
    var url: String = "",

    @ColumnInfo(name = "score")
    @SerializedName("score")
    @Expose
    var score: Int = 0,

    @ColumnInfo(name = "time")
    @SerializedName("time")
    @Expose
    var time: Long = 0,


    @TypeConverters(RoomConverter::class)
    @SerializedName("kids")
    @Expose
    var commentIds: List<Int> = emptyList()
) {

    var authorAndPoints = ""
        get() = "$score points by $by"

    var timeAndComment = ""
        get() = "${getRelativeTime(time)}  |  ${commentIds.size} comments"

}