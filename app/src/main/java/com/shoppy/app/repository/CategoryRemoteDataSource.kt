package com.shoppy.app.repository

import com.shoppy.app.model.Category
import com.shoppy.app.network.ApiClient

class CategoryRemoteDataSource(private val apiClient: ApiClient): CategoryDataSource {
    override suspend fun getCategories(): List<Category> {
        return apiClient.getCategories()
    }
}