package com.example.udf_viewmodel_navigation.presentation.home

sealed class HomeAction {
    object LearnClicked : HomeAction()
    object AddClicked : HomeAction()
    data class SetStats(val left: Int, val right: Int, val cards: Int) : HomeAction()
}