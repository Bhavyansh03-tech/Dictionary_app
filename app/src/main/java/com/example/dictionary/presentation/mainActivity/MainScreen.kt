package com.example.dictionary.presentation.mainActivity

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dictionary.presentation.lazyColumn.WordResult
import com.example.dictionary.presentation.viewModel.MainState

@Composable
fun MainScreen(
    mainState: MainState
) {
    // Adding word and phonetic displayed below search bar :->
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(MaterialTheme.colorScheme.background)
                .padding(horizontal = 30.dp)
        ) {

            mainState.wordItem?.let { wordItem ->

                // Setting up word :->
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = wordItem.word,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.primary
                )

                // Setting up phonetic :->
                Spacer(modifier = Modifier.height(8.dp))
                wordItem.phonetics.forEach { phonetic ->
                    Text(
                        text = phonetic.text,
                        fontSize = 17.sp,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))
            }
        }

        // Searching data :->
        Box(
            modifier = Modifier
                .padding(top = 110.dp)
                .fillMaxSize()
                .clip(RoundedCornerShape(topStart = 50.dp, topEnd = 50.dp))
                .background(MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.7f))
        ) {
            if (mainState.isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .size(80.dp)
                        .align(Alignment.Center),
                    color = MaterialTheme.colorScheme.primary
                )
            } else {
                // Displaying data :->
                mainState.wordItem?.let { wordItem ->
                    WordResult(wordItem)
                }
            }
        }
    }
}