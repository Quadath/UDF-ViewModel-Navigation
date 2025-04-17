package com.example.udf_viewmodel_navigation.model

import java.util.UUID

data class Word(
    val id: String = UUID.randomUUID().toString(),
    val word: String,
    val translation: String
)