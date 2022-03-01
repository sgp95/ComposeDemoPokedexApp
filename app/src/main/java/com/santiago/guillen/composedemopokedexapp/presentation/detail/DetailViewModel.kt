package com.santiago.guillen.composedemopokedexapp.presentation.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.santiago.guillen.composedemopokedexapp.domain.GetLocalPokemonEntryUseCase
import com.santiago.guillen.composedemopokedexapp.domain.model.Pokemon
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getLocalPokemonEntryUseCase: GetLocalPokemonEntryUseCase): ViewModel() {

    private val _pokemon = MutableLiveData<Pokemon>()
    val pokemon: LiveData<Pokemon> = _pokemon

    fun getPokemon(id: Int) {
        viewModelScope.launch {
            _pokemon.value = getLocalPokemonEntryUseCase.execute(id)
        }
    }
}