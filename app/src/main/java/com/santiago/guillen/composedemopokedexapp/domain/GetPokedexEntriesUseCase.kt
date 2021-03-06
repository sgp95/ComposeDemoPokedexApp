package com.santiago.guillen.composedemopokedexapp.domain

import com.santiago.guillen.composedemopokedexapp.Constants
import com.santiago.guillen.composedemopokedexapp.data.datasource.api.response.PokemonResponse
import com.santiago.guillen.composedemopokedexapp.data.datasource.api.response.PokemonSpecieResponse
import com.santiago.guillen.composedemopokedexapp.data.repository.PokedexRepository
import com.santiago.guillen.composedemopokedexapp.domain.model.*
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import javax.inject.Inject

class GetPokedexEntriesUseCase @Inject constructor(private val repository: PokedexRepository) {
    suspend fun execute(limit: Int = Constants.PAGE_SIZE, offset: Int)  =
        coroutineScope {
            val pokemonList = arrayListOf<Pokemon>()
            val pokemonEntries = async { repository.getPokedexEntries(limit, offset) }
            pokemonEntries.await().results.forEach { entry ->
                val id = entry.url.split("/")[6].toInt()
                val pokemonData = async { repository.getPokemon(id) }
                val pokemonSpecieData = async { repository.getPokemonSpecie(id) }
                pokemonList.add(mapResponse(pokemonData.await(), pokemonSpecieData.await()))
            }
            pokemonList
        }

    private fun mapResponse(pokemonResponse: PokemonResponse, pokemonSpecieResponse: PokemonSpecieResponse): Pokemon {
        return Pokemon(
            id = pokemonResponse.id,
            name = pokemonResponse.name!!.capitalize(),
            description = pokemonSpecieResponse.flavorTextEntries.find {
                it.version!!.name == "ruby" || it.version!!.name == "platinum" || it.version!!.name == "soulsilver"
            }?.flavorText,
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/${pokemonResponse.id}.png",
            genera = pokemonSpecieResponse.genera.find {
                it.language!!.name == "en"
            }?.genus,
            pokedexNumber = pokemonResponse.id.toString().padEnd(3, '0'),
            baseExperience = pokemonResponse.baseExperience,
            types = ArrayList(pokemonResponse.types.map { type ->
                Type(
                    name = type.type?.name,
                    url = type.type?.url
                )
            }),
            stats = ArrayList(pokemonResponse.stats.map { stat ->
                Stat(
                    baseValue = stat.baseStat,
                    url = stat.stat?.url,
                    name = when (stat.stat?.name) {
                        "hp" -> "HP"
                        "attack" -> "Attack"
                        "defense" -> "Defense"
                        "special-attack" -> "Sp. Atk"
                        "special-defense" -> "Sp. Def"
                        else -> "Speed"
                    }
                )
            }),
            height = pokemonResponse.height,
            weight = pokemonResponse.weight,
            genderRate = pokemonSpecieResponse.genderRate,
            abilities = ArrayList(pokemonResponse.abilities.map { ability ->
                Ability(
                    name = ability.ability?.name,
                    url = ability.ability?.url
                )
            }),
            eggGroup = ArrayList(pokemonSpecieResponse.eggGroups.map { group ->
                EggGroup(
                    name = group.name,
                    url = group.url
                )
            })
        )
    }
}