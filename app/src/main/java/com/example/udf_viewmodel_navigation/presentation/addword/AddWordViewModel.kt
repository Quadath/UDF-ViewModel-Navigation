package com.example.udf_viewmodel_navigation.presentation.addword

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class AddWordViewModel : ViewModel() {
    var word by mutableStateOf("")
        private set
    var translation by mutableStateOf("")
        private set

    fun onWordChange(new: String) {
        word = new
    }

    fun onTranslationChange(new: String) {
        translation = new
    }

    fun onSave() {
        println("Saving word: $word -> $translation")
    }
}