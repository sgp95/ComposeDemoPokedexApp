package com.santiago.guillen.composedemopokedexapp.data.datasource.interfaces

import com.santiago.guillen.composedemopokedexapp.data.datasource.api.response.PokedexEntryResponse
import com.santiago.guillen.composedemopokedexapp.data.datasource.api.response.PokemonResponse
import com.santiago.guillen.composedemopokedexapp.data.datasource.api.response.PokemonSpecieResponse

interface RemotePokedexData {
    suspend fun getPokedexData(limit: Int, offset: Int): PokedexEntryResponse
    suspend fun getPokemonData(id: Int): PokemonResponse
    suspend fun getPokemonSpecieData(id: Int): PokemonSpecieResponse
}