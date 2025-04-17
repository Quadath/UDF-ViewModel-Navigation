package com.example.udf_viewmodel_navigation.presentation.addword

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewModelScope
import com.example.udf_viewmodel_navigation.data.repository.RepositoryProvider
import com.example.udf_viewmodel_navigation.model.Word
import kotlinx.coroutines.launch

class AddWordViewModel : ViewModel() {
    private val repository = RepositoryProvider.wordRepository

    private val _state = mutableStateOf(AddWordState())
    val state: AddWordState by _state

    fun onAction(action: AddWordAction) {
        when (action) {
            is AddWordAction.WordChanged -> {
                _state.value = _state.value.copy(word = action.newWord)
            }
            is AddWordAction.TranslationChanged -> {
                _state.value = _state.value.copy(translation = action.newTranslation)
            }
            is AddWordAction.Save -> {
                viewModelScope.launch {
                    val newWord = Word(
                        word = _state.value.word,
                        translation = _state.value.translation
                    )
                    repository.addWord(newWord)
                }
            }
        }
    }
}