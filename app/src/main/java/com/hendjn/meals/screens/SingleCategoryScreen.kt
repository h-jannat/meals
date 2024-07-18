package com.hendjn.meals.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.hendjn.meals.components.NavBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SingleCategoryScreen(navController: NavController) {
    //Text(categoryName)
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { NavBar(navController) }) { innerPadding ->
        Box(modifier = Modifier.fillMaxSize().padding(innerPadding)) {

        }
    }
}