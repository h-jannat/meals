package com.hendjn.meals

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hendjn.meals.screens.RecipeScreen
import com.hendjn.meals.screens.SingleCategoryScreen
import com.hendjn.meals.vm.MainViewModel

@Composable
fun AppNavigateor() {
    val navController = rememberNavController()
    val recipeViewModel: MainViewModel = viewModel()
    val categoryState by recipeViewModel.categoriesState
    NavHost(navController = navController, startDestination = "/") {
        composable("/") {
            RecipeScreen(navController, recipeViewModel)
        }
        composable("/single-category") {
            SingleCategoryScreen(navController, categoryState.selectedCategory)
        }
        composable("/meal-details") {
            RecipeScreen(navController, recipeViewModel)
        }
    }
}