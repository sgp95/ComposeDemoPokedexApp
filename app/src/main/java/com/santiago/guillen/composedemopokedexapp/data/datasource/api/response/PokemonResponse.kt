package com.santiago.guillen.composedemopokedexapp.data.datasource.api.response

import com.google.gson.annotations.SerializedName


data class PokemonResponse(
    @SerializedName("abilities") var abilities: ArrayList<Abilities> = arrayListOf(),
    @SerializedName("base_experience") var baseExperience: Int? = null,
    @SerializedName("forms") var forms: ArrayList<Forms> = arrayListOf(),
    @SerializedName("game_indices") var gameIndices: ArrayList<GameIndices> = arrayListOf(),
    @SerializedName("height") var height: Int? = null,
    @SerializedName("id") var id: Int? = null,
    @SerializedName("is_default") var isDefault: Boolean? = null,
    @SerializedName("location_area_encounters") var locationAreaEncounters: String? = null,
    @SerializedName("moves") var moves: ArrayList<Moves> = arrayListOf(),
    @SerializedName("name") var name: String? = null,
    @SerializedName("order") var order: Int? = null,
    @SerializedName("species") var species: Species? = Species(),
    @SerializedName("sprites") var sprites: Sprites? = Sprites(),
    @SerializedName("stats") var stats: ArrayList<Stats> = arrayListOf(),
    @SerializedName("types") var types: ArrayList<Types> = arrayListOf(),
    @SerializedName("weight") var weight: Int? = null
)

data class Ability(
    @SerializedName("name") var name: String? = null,
    @SerializedName("url") var url: String? = null
)

data class Abilities(
    @SerializedName("ability") var ability: Ability? = Ability(),
    @SerializedName("is_hidden") var isHidden: Boolean? = null,
    @SerializedName("slot") var slot: Int? = null
)

data class Forms(
    @SerializedName("name") var name: String? = null,
    @SerializedName("url") var url: String? = null
)

data class GameIndices(
    @SerializedName("game_index") var gameIndex: Int? = null,
    @SerializedName("version") var version: VersionResponse? = VersionResponse()
)

data class Move(
    @SerializedName("name") var name: String? = null,
    @SerializedName("url") var url: String? = null
)

data class MoveLearnMethod(
    @SerializedName("name") var name: String? = null,
    @SerializedName("url") var url: String? = null
)

data class VersionGroup(
    @SerializedName("name") var name: String? = null,
    @SerializedName("url") var url: String? = null
)

data class VersionGroupDetails(
    @SerializedName("level_learned_at") var levelLearnedAt: Int? = null,
    @SerializedName("move_learn_method") var moveLearnMethod: MoveLearnMethod? = MoveLearnMethod(),
    @SerializedName("version_group") var versionGroup: VersionGroup? = VersionGroup()
)

data class Moves(
    @SerializedName("move") var move: Move? = Move(),
    @SerializedName("version_group_details") var versionGroupDetails: ArrayList<VersionGroupDetails> = arrayListOf()
)

data class Species(
    @SerializedName("name") var name: String? = null,
    @SerializedName("url") var url: String? = null
)

data class Sprites(
    @SerializedName("back_default") var backDefault: String? = null,
    @SerializedName("back_female") var backFemale: String? = null,
    @SerializedName("back_shiny") var backShiny: String? = null,
    @SerializedName("back_shiny_female") var backShinyFemale: String? = null,
    @SerializedName("front_default") var frontDefault: String? = null,
    @SerializedName("front_female") var frontFemale: String? = null,
    @SerializedName("front_shiny") var frontShiny: String? = null,
    @SerializedName("front_shiny_female") var frontShinyFemale: String? = null
)

data class Stat(
    @SerializedName("name") var name: String? = null,
    @SerializedName("url") var url: String? = null
)

data class Stats(
    @SerializedName("base_stat") var baseStat: Int? = null,
    @SerializedName("effort") var effort: Int? = null,
    @SerializedName("stat") var stat: Stat? = Stat()
)

data class Type(
    @SerializedName("name") var name: String? = null,
    @SerializedName("url") var url: String? = null
)

data class Types(
    @SerializedName("slot") var slot: Int? = null,
    @SerializedName("type") var type: Type? = Type()
)