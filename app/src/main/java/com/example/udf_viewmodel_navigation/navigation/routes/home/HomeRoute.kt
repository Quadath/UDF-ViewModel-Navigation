package com.example.udf_viewmodel_navigation.navigation.routes.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.udf_viewmodel_navigation.presentation.home.HomeViewModel
import androidx.compose.runtime.getValue
import com.example.udf_viewmodel_navigation.presentation.home.HomeAction
import com.example.udf_viewmodel_navigation.ui.screens.homescreen.HomeScreen

@Composable
fun HomeRoute(
    viewModel: HomeViewModel = viewModel(),
    onNavigateToLearn: () -> Unit,
    onNavigateToAdd: () -> Unit
) {
    val state by viewModel.state.collectAsState()

    HomeScreen(
        leftSwipes = state.leftSwipes,
        rightSwipes = state.rightSwipes,
        cardsToLearn = state.cardsToLearn,
        onLearnClick = {
            viewModel.onAction(HomeAction.LearnClicked)
            onNavigateToLearn()
        },
        onAddWordClick = {
            viewModel.onAction(HomeAction.AddClicked)
            onNavigateToAdd()
        }
    )
}