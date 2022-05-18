package com.shoppy.app.repository.home

import com.shoppy.app.model.HomeData

interface HomeDataSource {

    fun getHomeData(): HomeData?
}
