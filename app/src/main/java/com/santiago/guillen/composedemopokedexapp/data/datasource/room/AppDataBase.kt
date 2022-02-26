package com.santiago.guillen.composedemopokedexapp.data.datasource.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.santiago.guillen.composedemopokedexapp.data.datasource.room.dao.PokemonDao
import com.santiago.guillen.composedemopokedexapp.data.datasource.room.entities.Converters
import com.santiago.guillen.composedemopokedexapp.data.datasource.room.entities.PokemonEntity

@Database(entities = [PokemonEntity::class], version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase: RoomDatabase() {
    abstract fun pokemonDao(): PokemonDao
}