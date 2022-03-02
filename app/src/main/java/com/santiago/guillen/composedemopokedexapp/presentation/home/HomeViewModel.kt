package com.santiago.guillen.composedemopokedexapp.presentation.home

import androidx.compose.runtime.mutableStateOf
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

    var pokemonList = mutableStateOf<List<Pokemon>>(listOf())
    var isLoading = mutableStateOf(false)
    var endReached = mutableStateOf(false)

    init {
        getEntries()
    }

    fun getEntries() {
        isLoading.value = true
        viewModelScope.launch {
            val entries = getPokedexEntriesUseCase.execute(offset = currentPage * Constants.PAGE_SIZE).toList()
            savePokemonEntries(entries)
            if(entries.isNotEmpty()) {
                endReached.value = entries.size < Constants.PAGE_SIZE
                currentPage += 1
                isLoading.value = false
                pokemonList.value += entries
            }
        }
    }

    private fun savePokemonEntries(entries: List<Pokemon>) {
        viewModelScope.launch {
            savePokemonEntriesUseCase.execute(entries)
        }
    }
}