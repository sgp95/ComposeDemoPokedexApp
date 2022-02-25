package com.santiago.guillen.composedemopokedexapp.data.datasource.api.response

import com.google.gson.annotations.SerializedName


data class PokemonSpecieResponse(
    @SerializedName("base_happiness") var baseHappiness: Int? = null,
    @SerializedName("capture_rate") var captureRate: Int? = null,
    @SerializedName("color") var color: Color? = Color(),
    @SerializedName("egg_groups") var eggGroups: ArrayList<EggGroups> = arrayListOf(),
    @SerializedName("evolution_chain") var evolutionChain: EvolutionChain? = EvolutionChain(),
    @SerializedName("flavor_text_entries") var flavorTextEntries: ArrayList<FlavorTextEntries> = arrayListOf(),
    @SerializedName("form_descriptions") var formDescriptions: ArrayList<String> = arrayListOf(),
    @SerializedName("forms_switchable") var formsSwitchable: Boolean? = null,
    @SerializedName("gender_rate") var genderRate: Int? = null,
    @SerializedName("genera") var genera: ArrayList<Genera> = arrayListOf(),
    @SerializedName("generation") var generation: Generation? = Generation(),
    @SerializedName("growth_rate") var growthRate: GrowthRate? = GrowthRate(),
    @SerializedName("habitat") var habitat: Habitat? = Habitat(),
    @SerializedName("has_gender_differences") var hasGenderDifferences: Boolean? = null,
    @SerializedName("hatch_counter") var hatchCounter: Int? = null,
    @SerializedName("id") var id: Int? = null,
    @SerializedName("is_baby") var isBaby: Boolean? = null,
    @SerializedName("is_legendary") var isLegendary: Boolean? = null,
    @SerializedName("is_mythical") var isMythical: Boolean? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("names") var names: ArrayList<Names> = arrayListOf(),
    @SerializedName("order") var order: Int? = null,
    @SerializedName("pal_park_encounters") var palParkEncounters: ArrayList<PalParkEncounters> = arrayListOf(),
    @SerializedName("pokedex_numbers") var pokedexNumbers: ArrayList<PokedexNumbers> = arrayListOf(),
    @SerializedName("shape") var shape: Shape? = Shape(),
    @SerializedName("varieties") var varieties: ArrayList<Varieties> = arrayListOf()
)

data class Color(
    @SerializedName("name") var name: String? = null,
    @SerializedName("url") var url: String? = null
)

data class EggGroups(
    @SerializedName("name") var name: String? = null,
    @SerializedName("url") var url: String? = null
)

data class EvolutionChain(
    @SerializedName("url") var url: String? = null
)

data class Language(
    @SerializedName("name") var name: String? = null,
    @SerializedName("url") var url: String? = null
)

data class FlavorTextEntries(
    @SerializedName("flavor_text") var flavorText: String? = null,
    @SerializedName("language") var language: Language? = Language(),
    @SerializedName("version") var version: VersionResponse? = VersionResponse()
)

data class Genera(
    @SerializedName("genus") var genus: String? = null,
    @SerializedName("language") var language: Language? = Language()
)

data class Generation(
    @SerializedName("name") var name: String? = null,
    @SerializedName("url") var url: String? = null
)

data class GrowthRate(
    @SerializedName("name") var name: String? = null,
    @SerializedName("url") var url: String? = null
)

data class Habitat(
    @SerializedName("name") var name: String? = null,
    @SerializedName("url") var url: String? = null
)

data class Names(
    @SerializedName("language") var language: Language? = Language(),
    @SerializedName("name") var name: String? = null
)

data class Area(
    @SerializedName("name") var name: String? = null,
    @SerializedName("url") var url: String? = null
)

data class PalParkEncounters(
    @SerializedName("area") var area: Area? = Area(),
    @SerializedName("base_score") var baseScore: Int? = null,
    @SerializedName("rate") var rate: Int? = null
)

data class Pokedex(
    @SerializedName("name") var name: String? = null,
    @SerializedName("url") var url: String? = null
)

data class PokedexNumbers(
    @SerializedName("entry_number") var entryNumber: Int? = null,
    @SerializedName("pokedex") var pokedex: Pokedex? = Pokedex()
)

data class Shape(
    @SerializedName("name") var name: String? = null,
    @SerializedName("url") var url: String? = null
)

data class Pokemon(
    @SerializedName("name") var name: String? = null,
    @SerializedName("url") var url: String? = null
)

data class Varieties(
    @SerializedName("is_default") var isDefault: Boolean? = null,
    @SerializedName("pokemon") var pokemon: Pokemon? = Pokemon()
)