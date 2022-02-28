package com.santiago.guillen.composedemopokedexapp.domain

import com.santiago.guillen.composedemopokedexapp.data.repository.PokedexRepository
import com.santiago.guillen.composedemopokedexapp.domain.model.Pokemon
import javax.inject.Inject

class GetLocalPokemonEntryUseCase @Inject constructor(private val repository: PokedexRepository) {
    suspend fun execute(pokemonId: Int): Pokemon {
        val pokemonEntity = repository.getPokemonEntity(pokemonId)
        return  Pokemon(
            id = pokemonEntity.id,
            name = pokemonEntity.name,
            description = pokemonEntity.description,
            imageUrl = pokemonEntity.imageUrl,
            genera = pokemonEntity.genera,
            pokedexNumber = pokemonEntity.pokedexNumber,
            baseExperience = pokemonEntity.baseExperience,
            types = pokemonEntity.types,
            stats = pokemonEntity.stats,
            height = pokemonEntity.height,
            weight = pokemonEntity.weight,
            abilities = pokemonEntity.abilities,
            genderRate = pokemonEntity.genderRate,
            eggGroup = pokemonEntity.eggGroups
        )
    }
}