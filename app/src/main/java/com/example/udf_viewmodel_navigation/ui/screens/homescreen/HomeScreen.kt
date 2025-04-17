package com.example.udf_viewmodel_navigation.ui.screens.homescreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.udf_viewmodel_navigation.model.Word

@Composable
fun HomeScreen(
    leftSwipes: Int,
    rightSwipes: Int,
    cardsToLearn: Int,
    words: List<Word>,
    onLearnClick: () -> Unit,
    onAddWordClick: () -> Unit,
)
{
    Box(modifier = Modifier.fillMaxSize())
    {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally)
        {
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween) {
                Text(text = "L: $leftSwipes")
                Text(text = "R: $rightSwipes")
            }

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "$cardsToLearn",
                fontSize = 120.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.weight(1f))
            Button(
                onClick = onLearnClick,
                modifier = Modifier
                    .fillMaxWidth(0.6f)
                    .height(56.dp)
            ) {
                Text(text = "Learn", fontSize = 18.sp)
            }

            Spacer(modifier = Modifier.weight(2f))
            FloatingActionButton(
                onClick = onAddWordClick,
                modifier = Modifier
                    .padding(16.dp)
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add word")
            }
            WordList(words = words)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(
        leftSwipes = 12,
        rightSwipes = 30,
        cardsToLearn = 18,
        words = emptyList(),
        onLearnClick = {},
        onAddWordClick = {}
    )
}