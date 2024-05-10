package com.example.dictionary.domain.model

data class WordItem(
    val meanings: List<Meaning>,
    val phonetics: List<Phonetic>,
    val word: String
)