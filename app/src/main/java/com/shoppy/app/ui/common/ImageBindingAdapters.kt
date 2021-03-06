package com.shoppy.app.ui.common

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.shoppy.app.GlideApp

@BindingAdapter("imageUrl")
fun loadImage(view: ImageView, imageUrl: String?) {
    if (!imageUrl.isNullOrEmpty()) {
        GlideApp.with(view)
            .load(imageUrl)
            .into(view)
    }
}
