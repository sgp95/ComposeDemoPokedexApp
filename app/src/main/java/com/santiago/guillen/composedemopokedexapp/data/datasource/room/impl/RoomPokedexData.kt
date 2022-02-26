package com.santiago.guillen.composedemopokedexapp.data.datasource.room.impl

import com.santiago.guillen.composedemopokedexapp.data.datasource.interfaces.LocalPokedexData
import com.santiago.guillen.composedemopokedexapp.data.datasource.room.dao.PokemonDao
import com.santiago.guillen.composedemopokedexapp.data.datasource.room.entities.PokemonEntity
import javax.inject.Inject

class RoomPokedexData @Inject constructor (private val dao: PokemonDao): LocalPokedexData {
    override suspend fun savePokemon(pokemon: PokemonEntity) {
        dao.insertPokemon(pokemon)
    }

    override suspend fun savePokemonEntries(pokemonList: List<PokemonEntity>) {
        dao.insertAll(pokemonList)
    }

    override suspend fun getAllPokemon(): List<PokemonEntity> {
        return dao.getAllEntries()
    }

    override suspend fun getPokemon(pokemonId: Int): PokemonEntity {
        return dao.getPokemon(pokemonId)
    }
}