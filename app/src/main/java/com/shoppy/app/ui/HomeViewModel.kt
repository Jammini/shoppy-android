package com.shoppy.app.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.shoppy.app.Banner
import com.shoppy.app.Title

class HomeViewModel : ViewModel() {

    private val _title = MutableLiveData<Title>()
    val title: LiveData<Title> = _title

    private val _topBanner = MutableLiveData<List<Banner>>()
    val topBanners: LiveData<List<Banner>> = _topBanner

    fun loadHomeData() {
        // TODO Data Layer - Repository 요청
    }
}
