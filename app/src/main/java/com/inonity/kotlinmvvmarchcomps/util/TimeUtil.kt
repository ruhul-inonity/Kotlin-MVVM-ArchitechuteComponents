package com.inonity.kotlinmvvmarchcomps.util

import android.text.format.DateUtils

/**
 * Created by ruhul on 16,May,2019
 */

fun getRelativeTime(time: Long): String {
    return DateUtils.getRelativeTimeSpanString(
        time * 1000,
        System.currentTimeMillis(),
        DateUtils.DAY_IN_MILLIS,
        DateUtils.FORMAT_ABBREV_ALL
    ).toString()
}