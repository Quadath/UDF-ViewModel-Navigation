package com.example.udf_viewmodel_navigation.presentation.addword

sealed class AddWordAction {
    data class WordChanged(val newWord: String) : AddWordAction()
    data class TranslationChanged(val newTranslation: String) : AddWordAction()
    object Save : AddWordAction()
}