package com.santiago.guillen.composedemopokedexapp.domain

import com.santiago.guillen.composedemopokedexapp.data.datasource.room.entities.PokemonEntity
import com.santiago.guillen.composedemopokedexapp.data.repository.PokedexRepository
import com.santiago.guillen.composedemopokedexapp.domain.model.Pokemon
import javax.inject.Inject

class SavePokemonEntriesUseCase @Inject constructor(private val repository: PokedexRepository) {
    suspend fun execute(pokemonEntries: List<Pokemon>) {
        val pokemonEntities = pokemonEntries.map {
            PokemonEntity(
                id = it.id ?: 0,
                name = it.name ?: "",
                description = it.description ?: "",
                imageUrl = it.imageUrl ?: "",
                genera = it.genera ?: "",
                pokedexNumber = it.pokedexNumber ?: "",
                baseExperience = it.baseExperience ?: 0,
                types = it.types,
                stats = it.stats,
                height = it.height ?: 0,
                weight = it.weight ?: 0,
                abilities = it.abilities,
                genderRate = it.genderRate ?: 0,
                eggGroups = it.eggGroup
            )
        }

        repository.savePokemonList(pokemonEntities)
    }
}