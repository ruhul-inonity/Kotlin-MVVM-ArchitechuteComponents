package com.inonity.kotlinmvvmarchcomps.ui

import android.os.Bundle
import com.inonity.kotlinmvvmarchcomps.R
import com.inonity.kotlinmvvmarchcomps.base.BaseActivity
import com.inonity.kotlinmvvmarchcomps.util.addFragment

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addFragment(R.id.content_frame, ::HomeFragment)
    }
}
