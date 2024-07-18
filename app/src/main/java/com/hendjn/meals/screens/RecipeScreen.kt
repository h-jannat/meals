package com.hendjn.meals.screens


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.hendjn.meals.components.NavBar
import com.hendjn.meals.models.Category
import com.hendjn.meals.vm.MainViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeScreen(navController: NavController, recipeViewModel: MainViewModel) {
    val viewState by recipeViewModel.categoriesState
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { NavBar(navController) }) { innerPadding ->
        Box(modifier = Modifier.fillMaxSize().padding(innerPadding)) {

            if (viewState.loading) {
                CircularProgressIndicator()
            } else {

                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    contentPadding = PaddingValues(10.dp)
                ) {

                    viewState.list.forEachIndexed { _, category ->
                        item(span = { GridItemSpan(1) }) {
                            CategoryItem(category, navController, recipeViewModel)
                        }
//
                    }

                }
            }
        }

    }
}

@Composable
fun CategoryItem(category: Category, navController: NavController, recipeViewModel: MainViewModel) {

    fun goToSingleCategory() {
        recipeViewModel.selectCategory(category)
        navController.navigate("/single-category")
    }

    Card(modifier = Modifier.fillMaxWidth(0.5f).padding(5.dp), onClick = {
        goToSingleCategory()

    }) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            AsyncImage(
                model = category.strCategoryThumb,
                contentDescription = category.strCategory,
                modifier = Modifier.clickable(onClick = {
                    goToSingleCategory()
                }
                ),
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(category.strCategory)
        }
    }
}