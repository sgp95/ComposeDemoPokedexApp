package com.santiago.guillen.composedemopokedexapp.data.datasource.interfaces

import com.santiago.guillen.composedemopokedexapp.data.datasource.room.entities.PokemonEntity

interface LocalPokedexData {
    suspend fun savePokemon(pokemon: PokemonEntity)
    suspend fun savePokemonEntries(pokemonList: List<PokemonEntity>)
    suspend fun getAllPokemon(): List<PokemonEntity>
    suspend fun getPokemon(pokemonId: Int): PokemonEntity
}