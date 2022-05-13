package com.shoppy.app

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.google.gson.Gson

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val toolbarTitle = view.findViewById<TextView>(R.id.toolbar_home_title)
        val toolbarIcon = view.findViewById<ImageView>(R.id.toolbar_home_icon)
        val viewpager = view.findViewById<ViewPager2>(R.id.viewpager_home_banner)
        val viewpagerIndicator = view.findViewById<TabLayout>(R.id.viewpager_home_banner_indicator)

        val assetLoader = AssetLoader()
        val homeJsonString = assetLoader.getJsonString(requireContext(), "home.json")
        Log.d("homeData", homeJsonString ?: "")

        if (!homeJsonString.isNullOrEmpty()) {
            val gson = Gson()
            val homeData = gson.fromJson(homeJsonString, HomeData::class.java)

/*
            val jsonObject = JSONObject(homeJsonString)
            val title = jsonObject.getJSONObject("title")
            val text = title.getString("text")
            val iconUrl = title.getString("icon_url")
            val titleValue = Title(text, iconUrl)
*/

            toolbarTitle.text = homeData.title.text
            GlideApp.with(this)
                .load(homeData.title.iconUrl)
                .into(toolbarIcon)


/*            val topBanners = jsonObject.getJSONArray("top_banners")
            val size = topBanners.length()

            for (index in 0 until size) {
                val bannerObject = topBanners.getJSONObject(index)
                val backgroundImageUrl = bannerObject.getString("background_image_url")
                val badgeObject = bannerObject.getJSONObject("badge")
                val badgeLabel = badgeObject.getString("label")
                val badgeBackgroundColor = badgeObject.getString("background_color")
                val bannerBadge = BannerBadge(badgeLabel, badgeBackgroundColor)
                val banner = Banner(
                    backgroundImageUrl,
                    bannerBadge,
                    bannerLabel,
                    bannerProductDetail
                )
            }*/


            viewpager.adapter = HomeBannerAdapter().apply {
                submitList(homeData.topBanner)

            }

            val pageWidth = resources.getDimension(R.dimen.viewpager_item_width)
            val pageMargin = resources.getDimension(R.dimen.viewpager_item_margin)
            val screenWith = resources.displayMetrics.widthPixels
            val offset = screenWith - pageWidth - pageMargin

            viewpager.offscreenPageLimit = 3
            viewpager.setPageTransformer { page, position ->
                page.translationX = position * -offset
            }
            TabLayoutMediator(viewpagerIndicator, viewpager) { tab, position ->

            }.attach()
        }
    }
}
