package com.hendjn.meals

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeScreen(modifier: Modifier) {
    val recipeViewModel: MainViewModel = viewModel()
    val viewState by recipeViewModel.categoriesState

    Box(modifier = Modifier.fillMaxSize()) {
        TopAppBar(title = { Text("Recipes App") })
        if (viewState.loading) {
            CircularProgressIndicator()
        } else {


            LazyVerticalGrid(columns = GridCells.Fixed(2), contentPadding = PaddingValues(10.dp)) {

                viewState.list.forEachIndexed { _, category ->
                    item(span = { GridItemSpan(1) }) {
                        CategoryItem(category)
                    }
//
                }

            }
        }

    }
}

@Composable
fun CategoryItem(category: Category) {
    Card(modifier = Modifier.fillMaxWidth(0.5f).padding(5.dp)) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            AsyncImage(
                model = category.strCategoryThumb,
                contentDescription = category.strCategory,
            )
            Text(category.strCategory)
        }
    }
}