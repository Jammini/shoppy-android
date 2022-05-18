package com.shoppy.app.repository.category

import com.shoppy.app.model.Category

interface CategoryDataSource {

    suspend fun getCategories(): List<Category>
}