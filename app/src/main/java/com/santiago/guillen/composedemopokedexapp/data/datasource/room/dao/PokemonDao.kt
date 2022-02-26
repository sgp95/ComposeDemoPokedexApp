package com.santiago.guillen.composedemopokedexapp.data.datasource.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.santiago.guillen.composedemopokedexapp.data.datasource.room.entities.PokemonEntity

@Dao
interface PokemonDao {
    @Query("SELECT * FROM PokemonEntity")
    suspend fun getAllEntries(): List<PokemonEntity>

    @Query("SELECT * FROM PokemonEntity WHERE id = :pokemonId")
    suspend fun getPokemon(pokemonId: Int): PokemonEntity

    @Insert
    suspend fun insertPokemon(pokemon: PokemonEntity)

    @Insert
    suspend fun insertAll(pokemons: List<PokemonEntity>)
}