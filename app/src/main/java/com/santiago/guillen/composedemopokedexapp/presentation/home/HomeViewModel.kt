package com.santiago.guillen.composedemopokedexapp.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.santiago.guillen.composedemopokedexapp.domain.GetPokedexEntriesUseCase
import com.santiago.guillen.composedemopokedexapp.domain.model.Pokemon
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val getPokedexEntriesUseCase: GetPokedexEntriesUseCase): ViewModel() {
    private val _pokedexEntries = MutableLiveData<List<Pokemon>>()
    val pokedexEntries: LiveData<List<Pokemon>> = _pokedexEntries

    fun getEntries(offSet: Int = 0) {
        viewModelScope.launch {
            val entries = getPokedexEntriesUseCase.execute(offset = offSet).toList()
            _pokedexEntries.value = entries
        }
    }
}