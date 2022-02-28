package com.santiago.guillen.composedemopokedexapp.domain.model

data class Pokemon (
    var id: Int? = null,
    var name: String? = null,
    var description: String? = null,
    var imageUrl: String? = null,
    var genera: String? = null,
    var pokedexNumber: String? = null,
    var baseExperience: Int? = null,
    var types: ArrayList<Type> = arrayListOf(),
    var stats: ArrayList<Stat> = arrayListOf(),
    var height: Int? = null,
    var weight: Int? = null,
    var abilities: ArrayList<Ability> = arrayListOf(),
    var genderRate: Int? = null,
    var eggGroup: ArrayList<EggGroup> = arrayListOf()
)

data class Type (
    var name: String? = null,
    var url: String? = null
)

data class Stat (
    var name: String? = null,
    var baseValue: Int? = null,
    var url: String? = null
)

data class Ability (
    var name: String? = null,
    var url: String? = null
)

data class EggGroup (
    var name: String? = null,
    var url: String? = null
)