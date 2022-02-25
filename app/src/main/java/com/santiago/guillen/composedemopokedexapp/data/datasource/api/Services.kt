package com.santiago.guillen.composedemopokedexapp.data.datasource.api

import com.santiago.guillen.composedemopokedexapp.data.datasource.api.response.PokedexEntryResponse
import com.santiago.guillen.composedemopokedexapp.data.datasource.api.response.PokemonResponse
import com.santiago.guillen.composedemopokedexapp.data.datasource.api.response.PokemonSpecieResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Services {
    @GET(Endpoints.POKEDEX)
    suspend fun getPokedexEntries(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): PokedexEntryResponse

    @GET(Endpoints.POKEMON)
    suspend fun getPokemonData(
        @Path("id") id: Int
    ): PokemonResponse

    @GET(Endpoints.POKEMON_SPECIE)
    suspend fun getPokemonSpecie(
        @Path("id") id: Int
    ): PokemonSpecieResponse
}