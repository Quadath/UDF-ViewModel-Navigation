package com.example.udf_viewmodel_navigation.presentation.home

import com.example.udf_viewmodel_navigation.model.Word

data class HomeState(
    val leftSwipes: Int = 0,
    val rightSwipes: Int = 0,
    val cardsToLearn: Int = 0,
    val words: List<Word> = emptyList()
)