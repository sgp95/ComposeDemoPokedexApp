package com.santiago.guillen.composedemopokedexapp.data.datasource.api.impl

import com.santiago.guillen.composedemopokedexapp.data.datasource.api.Services
import com.santiago.guillen.composedemopokedexapp.data.datasource.interfaces.RemotePokedexData
import javax.inject.Inject

class ApiPokedexData @Inject constructor(private val service: Services): RemotePokedexData {
    override suspend fun getPokedexData(limit: Int, offset: Int) =
        service.getPokedexEntries(limit, offset)

    override suspend fun getPokemonData(id: Int) =
        service.getPokemonData(id)

    override suspend fun getPokemonSpecieData(id: Int) =
        service.getPokemonSpecie(id)
}