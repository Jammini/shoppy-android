package com.shoppy.app.repository

import com.shoppy.app.model.HomeData

interface HomeDataSource {

    fun getHomeData(): HomeData?
}
