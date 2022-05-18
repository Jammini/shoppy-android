package com.shoppy.app.repository

import com.shoppy.app.model.Category

interface CategoryDataSource {

    suspend fun getCategories(): List<Category>
}