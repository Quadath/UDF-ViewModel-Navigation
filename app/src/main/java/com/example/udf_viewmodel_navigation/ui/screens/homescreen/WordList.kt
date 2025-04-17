package com.example.udf_viewmodel_navigation.ui.screens.homescreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.udf_viewmodel_navigation.model.Word

@Composable
fun WordList(
    words: List<Word>,
    modifier: Modifier = Modifier
) {
    val visibleWords = words.takeLast(5).reversed()

    Column(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight(0.35f)
            .padding(horizontal = 16.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(MaterialTheme.colorScheme.surfaceVariant)
            .padding(8.dp)
    ) {
        Text(
            text = "Last Words",
            style = typography.titleMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(visibleWords.size) { index ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    shape = RoundedCornerShape(12.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .padding(12.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = visibleWords[index].word, fontWeight = FontWeight.Bold)
                        Text(text = visibleWords[index].translation)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WordListPreview() {
    val sampleWords = listOf(
        Word(word = "Der Apfel", translation = "apple"),
        Word(word = "Das Buch", translation = "book"),
        Word(word = "Die Katze", translation = "cat")
    )
    WordList(
        words = sampleWords
    )
}

