package com.inonity.kotlinmvvmarchcomps.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.google.gson.Gson
import com.inonity.kotlinmvvmarchcomps.base.BaseFragment
import com.inonity.kotlinmvvmarchcomps.databinding.FragmentHomeBinding
import com.inonity.kotlinmvvmarchcomps.di.ActivityScoped
import javax.inject.Inject

/**
 * Created by ruhul on 21,May,2019
 */

@ActivityScoped
class HomeFragment @Inject constructor() : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var homeViewModel: HomeViewModel
    private lateinit var binding: FragmentHomeBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        homeViewModel = ViewModelProviders.of(this, viewModelFactory).get(HomeViewModel::class.java)

        binding = FragmentHomeBinding.inflate(inflater, container, false).apply {
            //this.viewModel = homeViewModel
            //this.adapter = newsAdapter
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeViewModel.start()
        handleUIEvent()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        homeViewModel.stop()
    }

    private fun handleUIEvent() {
        homeViewModel.onNewsOpenEvent.observe(this, Observer { news ->
            news?.let {
               // val intent = Intent(context, CommentActivity::class.java)
               // intent.putExtra(NEWS_DATA, Gson().toJson(it))
               // startActivity(intent)
            }
        })
    }

}