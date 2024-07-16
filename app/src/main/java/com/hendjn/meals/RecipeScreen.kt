package com.hendjn.meals

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage


@Composable
fun RecipeScreen(modifier: Modifier) {
    val recipeViewModel: MainViewModel = viewModel()
    val viewState by recipeViewModel.categoriesState

    Box(modifier = Modifier.fillMaxSize()) {
        if (viewState.loading) {
            CircularProgressIndicator()
        } else {
            LazyVerticalGrid(columns = GridCells.Fixed(2)) {

                viewState.list.forEachIndexed { index, category ->
                    item(span = { GridItemSpan(maxLineSpan) }) {
                        Card {
                            Column {
                                AsyncImage(
                                    model = category.strCategoryThumb,
                                    contentDescription = category.strCategory,
                                )
                            }
                        }
                    }
//
                }

            }
        }

    }
}