package com.santiago.guillen.composedemopokedexapp.data.repository

import com.santiago.guillen.composedemopokedexapp.data.datasource.interfaces.RemotePokedexData
import javax.inject.Inject

class PokedexRepository @Inject constructor(private val remoteDataSource: RemotePokedexData) {
    suspend fun getPokedexEntries(limit: Int, offset: Int) = remoteDataSource.getPokedexData(limit, offset)
    suspend fun getPokemon(id: Int) = remoteDataSource.getPokemonData(id)
    suspend fun getPokemonSpecie(id: Int) = remoteDataSource.getPokemonSpecieData(id)
}