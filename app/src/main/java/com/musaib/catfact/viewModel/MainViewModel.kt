package com.musaib.catfact.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.musaib.catfact.netwrok.CatFactRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: CatFactRepository
) : ViewModel() {

    private val _catFact = MutableStateFlow("Cat's are awesome")
    val catFact = _catFact.asStateFlow()

     fun fetchCatFact() {
        viewModelScope.launch {
            try {
                val fact = repository.fetchCatFact()
                _catFact.value = fact.fact
            } catch (e: Exception) {
                _catFact.value = "Failed to load fact"
            }
        }
    }
}