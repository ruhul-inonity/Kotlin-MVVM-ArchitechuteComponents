package com.inonity.kotlinmvvmarchcomps.util

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

/**
 * Created by ruhul on 15,May,2019
 */

inline fun AppCompatActivity.addFragment(containerViewId: Int, f: () -> Fragment): Fragment? {
    return f().apply { supportFragmentManager?.beginTransaction()?.add(containerViewId, this)?.commit() }
}

inline fun AppCompatActivity.addFragment(containerViewId: Int, bundle: Bundle, f: () -> Fragment): Fragment? {
    return f().apply {
        arguments = bundle
        supportFragmentManager?.beginTransaction()?.add(containerViewId, this)?.commit()
    }
}

inline fun AppCompatActivity.replaceFragment(containerViewId: Int, f: () -> Fragment): Fragment? {
    return f().apply { supportFragmentManager?.beginTransaction()?.replace(containerViewId, this)?.commit() }
}