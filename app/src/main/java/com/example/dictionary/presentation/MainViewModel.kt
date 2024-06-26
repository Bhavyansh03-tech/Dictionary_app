package com.example.dictionary.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dictionary.domain.repository.DictionaryRepository
import com.example.dictionary.util.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val dictionaryRepository: DictionaryRepository
): ViewModel() {

    // Create state variable :->
    private val _mainState = MutableStateFlow(MainState())
    private val mainState = _mainState.asStateFlow()

    private val searchJob: Job? = null

    fun onEvent(mainUiEvent: MainUiEvents){
        when (mainUiEvent){
            MainUiEvents.OnSearchClick -> {
                loadWordResult()
            }
            is MainUiEvents.OnSearchWordChange -> {
                _mainState.update {
                    it.copy(searchWord = mainUiEvent.newWord.lowercase())
                }
            }
        }
    }

    private fun loadWordResult() {
        viewModelScope.launch {
            dictionaryRepository.getWordResult(
                mainState.value.searchWord
            ).collect { result ->
                when (result) {
                    is Result.Error -> Unit
                    is Result.Loading -> {
                        _mainState.update {
                            it.copy(isLoading = result.isLoading)
                        }
                    }
                    is Result.Success -> {
                        result.data?.let { wordItem ->
                            _mainState.update {
                                it.copy(wordItem = wordItem)
                            }
                        }
                    }
                }
            }
        }
    }

}