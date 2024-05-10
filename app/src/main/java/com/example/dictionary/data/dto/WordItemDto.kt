package com.example.dictionary.data.dto

data class WordItemDto(
    val meanings: List<MeaningDto>? = null,
    val phonetics: List<PhoneticDto>? = null,
    val word: String? = null
)