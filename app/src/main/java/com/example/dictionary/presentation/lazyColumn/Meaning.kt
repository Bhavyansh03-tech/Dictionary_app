package com.example.dictionary.presentation.lazyColumn

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dictionary.R
import com.example.dictionary.domain.model.Meaning

@Composable
fun Meaning(
    meaning: Meaning,
    index: Int
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {

        // Displaying part of speech :->
        Text(
            text = "${index + 1}. ${meaning.partOfSpeech}",
            fontSize = 17.sp,
            color =  MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(20.dp))
                .background(
                    brush = Brush.horizontalGradient(
                        listOf(
                            MaterialTheme.colorScheme.primary,
                            MaterialTheme.colorScheme.primary.copy(0.4f),
                            Color.Transparent
                        )
                    )
                )
                .padding(12.dp, 2.dp, 12.dp, 4.dp)
        )

        // Displaying meaning - definition in lazy column :->
        if (meaning.definitions.definition.isNotEmpty()){

            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.padding(horizontal = 8.dp)
            ) {
                Text(
                    text = stringResource(R.string.definition),
                    fontSize = 19.sp,
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.SemiBold
                )

                Spacer(modifier = Modifier.width(12.dp))

                Text(
                    text = meaning.definitions.definition,
                    fontSize = 17.sp,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }

        }

        // Displaying meaning - example in lazy column :->
        if (meaning.definitions.example.isNotEmpty()){

            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.padding(horizontal = 8.dp)
            ) {
                Text(
                    text = stringResource(R.string.example),
                    fontSize = 19.sp,
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.SemiBold
                )

                Spacer(modifier = Modifier.width(12.dp))

                Text(
                    text = meaning.definitions.example,
                    fontSize = 17.sp,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }

        }

    }
}