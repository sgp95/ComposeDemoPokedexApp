package com.santiago.guillen.composedemopokedexapp.data.datasource.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.santiago.guillen.composedemopokedexapp.domain.model.Ability
import com.santiago.guillen.composedemopokedexapp.domain.model.EggGroup
import com.santiago.guillen.composedemopokedexapp.domain.model.Stat
import com.santiago.guillen.composedemopokedexapp.domain.model.Type

@Entity
data class PokemonEntity (
    @PrimaryKey val id:Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "image_url") val imageUrl: String,
    @ColumnInfo(name = "genera") val genera: String,
    @ColumnInfo(name = "pokedex_number") val pokedexNumber: String,
    @ColumnInfo(name = "base_experience") val baseExperience: Int,
    @ColumnInfo(name = "types") val types: ArrayList<Type>,
    @ColumnInfo(name = "stats") val stats: ArrayList<Stat>,
    @ColumnInfo(name = "height") val height: Int,
    @ColumnInfo(name = "weight") val weight: Int,
    @ColumnInfo(name = "abilities") val abilities: ArrayList<Ability>,
    @ColumnInfo(name = "gender_rate") val genderRate: Int,
    @ColumnInfo(name = "egg_groups") val eggGroups: ArrayList<EggGroup>,
)