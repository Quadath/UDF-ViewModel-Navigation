package com.example.udf_viewmodel_navigation.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.udf_viewmodel_navigation.data.repository.RepositoryProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel: ViewModel() {
    private val repository = RepositoryProvider.wordRepository

    private val _state = MutableStateFlow(HomeState())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            repository.getWords().collect { words ->
                _state.update { it.copy(words = words) }
            }
        }
    }

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