package com.shoppy.app.repository

import com.shoppy.app.model.HomeData

class HomeRepository(private val assetDataSource: HomeAssetDataSource) {


    fun getHomeData(): HomeData? {
        return assetDataSource.getHomeData()
    }
}
