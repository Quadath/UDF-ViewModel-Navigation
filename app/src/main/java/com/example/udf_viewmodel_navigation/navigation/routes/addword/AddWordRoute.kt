package com.example.udf_viewmodel_navigation.navigation.routes.addword

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.udf_viewmodel_navigation.presentation.addword.AddWordViewModel
import com.example.udf_viewmodel_navigation.ui.screens.AddWordScreen

@Composable
fun AddWordRoute(
    viewModel: AddWordViewModel = viewModel(),
    onBack: () -> Unit
) {
    AddWordScreen(
        word = viewModel.word,
        translation = viewModel.translation,
        onWordChange = viewModel::onWordChange,
        onTranslationChange = viewModel::onTranslationChange,
        onSave = {
            viewModel.onSave()
            onBack()
        },
        onBack = onBack
    )
}
