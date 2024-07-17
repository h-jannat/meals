package com.hendjn.meals

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private var _categoriesState: MutableState<RecipesState> = mutableStateOf(RecipesState())
    val categoriesState: State<RecipesState> = _categoriesState

    data class RecipesState(
        val loading: Boolean = true,
        val list: List<Category> = emptyList(),
        val error: String? = null
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

}