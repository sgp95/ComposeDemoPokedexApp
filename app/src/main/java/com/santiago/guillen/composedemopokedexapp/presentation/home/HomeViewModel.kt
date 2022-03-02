package com.santiago.guillen.composedemopokedexapp.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.santiago.guillen.composedemopokedexapp.Constants
import com.santiago.guillen.composedemopokedexapp.domain.GetPokedexEntriesUseCase
import com.santiago.guillen.composedemopokedexapp.domain.SavePokemonEntriesUseCase
import com.santiago.guillen.composedemopokedexapp.domain.model.Pokemon
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getPokedexEntriesUseCase: GetPokedexEntriesUseCase,
    private val savePokemonEntriesUseCase: SavePokemonEntriesUseCase): ViewModel() {

    private var currentPage = 0

    private val _pokedexEntries = MutableLiveData<List<Pokemon>>()
    val pokedexEntries: LiveData<List<Pokemon>> = _pokedexEntries

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun getEntries() {
        _isLoading.value = false
        viewModelScope.launch {
            val entries = getPokedexEntriesUseCase.execute(offset = currentPage * Constants.PAGE_SIZE).toList()
            savePokemonEntries(entries)
            if(entries.isNotEmpty()) {
                currentPage += 1
                _isLoading.value = true
                _pokedexEntries.value = entries
            }
        }
    }

    private fun savePokemonEntries(entries: List<Pokemon>) {
        viewModelScope.launch {
            savePokemonEntriesUseCase.execute(entries)
        }
    }
}