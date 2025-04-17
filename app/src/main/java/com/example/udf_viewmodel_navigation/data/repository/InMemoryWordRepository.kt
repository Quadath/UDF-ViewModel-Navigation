package com.example.udf_viewmodel_navigation.data.repository

import com.example.udf_viewmodel_navigation.model.Word
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class InMemoryWordRepository : WordRepository {
    private val wordList = MutableStateFlow<List<Word>>(emptyList())
    override fun getWords(): Flow<List<Word>> = wordList

    override suspend fun addWord(word: Word) {
        wordList.value = wordList.value + word
    }
}