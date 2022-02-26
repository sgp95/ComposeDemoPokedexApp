package com.santiago.guillen.composedemopokedexapp.data.repository

import com.santiago.guillen.composedemopokedexapp.data.datasource.interfaces.LocalPokedexData
import com.santiago.guillen.composedemopokedexapp.data.datasource.interfaces.RemotePokedexData
import com.santiago.guillen.composedemopokedexapp.data.datasource.room.entities.PokemonEntity
import javax.inject.Inject

class PokedexRepository @Inject constructor(
    private val remoteDataSource: RemotePokedexData,
    private val localDataSource: LocalPokedexData) {
    suspend fun getPokedexEntries(limit: Int, offset: Int) = remoteDataSource.getPokedexData(limit, offset)
    suspend fun getPokemon(id: Int) = remoteDataSource.getPokemonData(id)
    suspend fun getPokemonSpecie(id: Int) = remoteDataSource.getPokemonSpecieData(id)

    suspend fun savePokemon(pokemon: PokemonEntity) {
        localDataSource.savePokemon(pokemon)
    }
    suspend fun savePokemonList(pokemonList: List<PokemonEntity>) {
        localDataSource.savePokemonEntries(pokemonList)
    }
    suspend fun getAllPokemonEntities() = localDataSource.getAllPokemon()
    suspend fun getPokemonEntity(pokemonId: Int) = localDataSource.getPokemon(pokemonId)
}