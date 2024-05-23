package com.example.dictionary.presentation.lazyColumn

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.example.dictionary.domain.model.WordItem

@Composable
fun WordResult(wordItem: WordItem) {

    // Setting up recycler view or lazy column to display data :->
    LazyColumn (
        contentPadding = PaddingValues(vertical = 32.dp)
    ) {

        items(wordItem.meanings.size) { index ->
            Meaning(
                meaning = wordItem.meanings[index],
                index = index
            )
        }

    }
}