package com.example.udf_viewmodel_navigation.data.repository

import com.example.udf_viewmodel_navigation.model.Word
import kotlinx.coroutines.flow.Flow

interface WordRepository {
    fun getWords(): Flow<List<Word>>
    suspend fun addWord(word: Word)
}