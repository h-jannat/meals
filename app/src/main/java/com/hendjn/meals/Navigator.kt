package com.hendjn.meals

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hendjn.meals.screens.RecipeScreen
import com.hendjn.meals.screens.SingleCategoryScreen

@Composable
fun AppNavigateor() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "/") {
        composable("/") {
            RecipeScreen(navController)
        }
        composable("/single-category") {
            SingleCategoryScreen(navController)
        }
        composable("/meal-details") {
            RecipeScreen(navController)
        }
    }
}