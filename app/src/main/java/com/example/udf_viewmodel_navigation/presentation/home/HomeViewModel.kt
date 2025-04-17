package com.example.udf_viewmodel_navigation.presentation.home

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class HomeViewModel: ViewModel() {
    private val _state = MutableStateFlow(HomeState())
    val state = _state.asStateFlow()

    fun onAction(action: HomeAction) {
        when (action) {
            is HomeAction.LearnClicked -> println("Learn")
            is HomeAction.AddClicked -> println("Add")
            is HomeAction.SetStats -> {
                _state.update {
                    it.copy(
                        leftSwipes = action.left,
                        rightSwipes = action.right,
                        cardsToLearn = action.cards
                    )
                }
            }
        }
    }
}