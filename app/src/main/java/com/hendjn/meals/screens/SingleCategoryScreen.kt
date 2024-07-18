package com.hendjn.meals.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.hendjn.meals.components.NavBar
import com.hendjn.meals.models.Category

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SingleCategoryScreen(navController: NavController, selectedCategory: Category?) {
    //Text(categoryName)
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { NavBar(navController) }) { innerPadding ->
        Box(modifier = Modifier.fillMaxSize().padding(innerPadding)) {

            Column(
                modifier = Modifier.fillMaxSize(),
                //   horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                AsyncImage(
                    model = selectedCategory?.strCategoryThumb,
                    contentDescription = selectedCategory?.strCategory,
                )
                Spacer(modifier = Modifier.height(10.dp))
                selectedCategory?.strCategory?.let {
                    Text(
                        it
                    )
                }
            }
        }
    }
}