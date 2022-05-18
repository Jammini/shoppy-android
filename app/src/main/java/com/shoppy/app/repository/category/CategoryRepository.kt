package com.shoppy.app.repository.category

import com.shoppy.app.model.Category

class CategoryRepository(
    private val remoteDataSource: CategoryRemoteDataSource
) {
    suspend fun getCategories(): List<Category> {
        return remoteDataSource.getCategories()
    }
}