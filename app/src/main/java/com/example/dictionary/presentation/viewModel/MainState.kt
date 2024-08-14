package com.example.dictionary.presentation.viewModel

import com.example.dictionary.domain.model.WordItem

data class MainState(
    val isLoading: Boolean = false,
    val searchWord: String = "",
    val wordItem: WordItem? = null
)