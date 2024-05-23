package com.example.dictionary.presentation.viewModel

sealed class MainUiEvents {

    data class OnSearchWordChange(val newWord: String) : MainUiEvents()
    data object OnSearchClick : MainUiEvents()

}