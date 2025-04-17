package com.example.udf_viewmodel_navigation.navigation.routes.addword

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.udf_viewmodel_navigation.presentation.addword.AddWordAction
import com.example.udf_viewmodel_navigation.presentation.addword.AddWordViewModel
import com.example.udf_viewmodel_navigation.ui.screens.AddWordScreen

@Composable
fun AddWordRoute(
    viewModel: AddWordViewModel = viewModel(),
    onBack: () -> Unit
) {
    AddWordScreen(
        word = viewModel.state.word,
        translation = viewModel.state.translation,
        onWordChange = { newWord: String ->
            viewModel.onAction(AddWordAction.WordChanged(newWord))
        },
        onTranslationChange = { newTranslation: String ->
            viewModel.onAction(AddWordAction.TranslationChanged(newTranslation))
        },
        onSave = {
            viewModel.onAction(AddWordAction.Save)
            onBack()
        },
        onBack = onBack
    )
}
