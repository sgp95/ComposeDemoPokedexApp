package com.santiago.guillen.composedemopokedexapp.ui.theme

import androidx.compose.ui.graphics.Color

val Primary = Color(0xFFf44336)
val PrimaryLight = Color(0xFFff7961)
val PrimaryDark = Color(0xFFba000d)
val TextOnPrimary = Color(0xFFfafafa)
val Secondary = Color(0xFF90a4ae)
val SecondaryLight = Color(0xFFc1d5e0)
val SecondaryDark = Color(0xFF62757f)
val TextOnSecondary = Color(0xFF000000)

val NormalType = Color(0xFFA8A878)
val FightingType = Color(0xFFC03028)
val FlyingType = Color(0xFFA890F0)
val PoisonType = Color(0xFFA040A0)
val GroundType = Color(0xFFE0C068)
val RockType = Color(0xFFB8A038)
val BugType = Color(0xFFA8B820)
val GhostType = Color(0xFF705898)
val SteelType = Color(0xFFB8B8D0)
val FireType = Color(0xFFFA6C6C)
val WaterType = Color(0xFF6890F0)
val GrassType = Color(0xFF48CFB2)
val ElectricType = Color(0xFFFFCE4B)
val PsychicType = Color(0xFFF85888)
val IceType = Color(0xFF98D8D8)
val DragonType = Color(0xFF7038F8)
val DarkType = Color(0xFF705848)
val FairyType = Color(0xFFEE99AC)

val PokeballInCard = Color(0x33FAFAFA)

fun colorByType(type: String) = when(type) {
    "fighting" -> FightingType
    "flying" -> FlyingType
    "poison" -> PoisonType
    "ground" -> GroundType
    "rock" -> RockType
    "bug" -> BugType
    "ghost" -> GhostType
    "steel" -> SteelType
    "fire" -> FireType
    "water" -> WaterType
    "grass" -> GrassType
    "electric" -> ElectricType
    "psychic" -> PsychicType
    "ice" -> IceType
    "dragon" -> DragonType
    "dark" -> DarkType
    "fairy" -> FairyType
    else -> NormalType
}