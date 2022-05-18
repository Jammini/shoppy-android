package com.shoppy.app.ui.common

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shoppy.app.AssetLoader
import com.shoppy.app.network.ApiClient
import com.shoppy.app.repository.CategoryRemoteDataSource
import com.shoppy.app.repository.CategoryRepository
import com.shoppy.app.repository.HomeAssetDataSource
import com.shoppy.app.repository.HomeRepository
import com.shoppy.app.ui.category.CategoryViewModel
import com.shoppy.app.ui.home.HomeViewModel
import java.lang.IllegalArgumentException

class ViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(HomeViewModel::class.java) -> {
                val repository = HomeRepository(HomeAssetDataSource(AssetLoader(context)))
                HomeViewModel(repository) as T
            }
            modelClass.isAssignableFrom(CategoryViewModel::class.java) -> {
                val repository = CategoryRepository(CategoryRemoteDataSource(ApiClient.create()))
                CategoryViewModel(repository) as T
            }
            else -> {
                throw IllegalArgumentException("Failed to create ViewModel: ${modelClass.name}")
            }
        }
    }
}
