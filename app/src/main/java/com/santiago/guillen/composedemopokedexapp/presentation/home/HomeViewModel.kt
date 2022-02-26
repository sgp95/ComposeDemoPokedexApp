package com.santiago.guillen.composedemopokedexapp.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.santiago.guillen.composedemopokedexapp.domain.GetLocalPokemonEntryUseCase
import com.santiago.guillen.composedemopokedexapp.domain.GetPokedexEntriesUseCase
import com.santiago.guillen.composedemopokedexapp.domain.SavePokemonEntriesUseCase
import com.santiago.guillen.composedemopokedexapp.domain.model.Pokemon
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getPokedexEntriesUseCase: GetPokedexEntriesUseCase,
    private val savePokemonEntriesUseCase: SavePokemonEntriesUseCase,
    private val getLocalPokemonEntryUseCase: GetLocalPokemonEntryUseCase): ViewModel() {

    private val _pokedexEntries = MutableLiveData<List<Pokemon>>()
    val pokedexEntries: LiveData<List<Pokemon>> = _pokedexEntries

    private val _pokemon = MutableLiveData<Pokemon>()
    val pokemon: LiveData<Pokemon> = _pokemon

    fun getEntries(offSet: Int = 0) {
        viewModelScope.launch {
            val entries = getPokedexEntriesUseCase.execute(offset = offSet).toList()
            savePokemonEntries(entries)
            _pokedexEntries.value = entries
        }
    }

    private fun savePokemonEntries(entries: List<Pokemon>) {
        viewModelScope.launch {
            savePokemonEntriesUseCase.execute(entries)
        }
    }

    fun getPokemon(id: Int) {
        viewModelScope.launch {
            _pokemon.value = getLocalPokemonEntryUseCase.execute(id)
        }
    }
}