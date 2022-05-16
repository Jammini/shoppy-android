package com.shoppy.app.model

import com.google.gson.annotations.SerializedName
import com.shoppy.app.Banner

data class HomeData(
    val title: Title,
    @SerializedName("top_banners") val topBanners: List<Banner>
)
