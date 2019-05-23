package com.inonity.kotlinmvvmarchcomps.base

import androidx.lifecycle.ViewModel

/**
 * Created by ruhul on 15,May,2019
 */

abstract class BaseViewModel : ViewModel() {
    abstract fun start()

    abstract fun stop()
}