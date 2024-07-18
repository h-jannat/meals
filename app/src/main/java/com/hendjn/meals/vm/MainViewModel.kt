package com.hendjn.meals.vm

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hendjn.meals.api.recipesService
import com.hendjn.meals.models.CategoriesResponse
import com.hendjn.meals.models.Category
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private var _categoriesState: MutableState<RecipesState> = mutableStateOf(RecipesState())
    val categoriesState: State<RecipesState> = _categoriesState

    data class RecipesState(
        val loading: Boolean = true,
        val selectedCategory: Category? = null,
        val list: List<Category> = emptyList(),
        val error: String? = null,

        )

    init {
        getCategories()
    }

    private fun getCategories() {
        viewModelScope.launch {
            try {
                val response: CategoriesResponse = recipesService.getCategories()
                _categoriesState.value = RecipesState(loading = false, list = response.categories)
            } catch (e: Exception) {
                _categoriesState.value = _categoriesState.value.copy(
                    loading = false,
                    error = "Fetch categories exception ${e.message}"
                )
            }
        }
    }

    fun selectCategory(category: Category) {

        _categoriesState.value = _categoriesState.value.copy(
            selectedCategory = category
        )

    }

}