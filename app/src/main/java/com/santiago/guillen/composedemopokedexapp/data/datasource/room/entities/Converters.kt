package com.santiago.guillen.composedemopokedexapp.data.datasource.room.entities

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.santiago.guillen.composedemopokedexapp.domain.model.Ability
import com.santiago.guillen.composedemopokedexapp.domain.model.EggGroup
import com.santiago.guillen.composedemopokedexapp.domain.model.Stat
import com.santiago.guillen.composedemopokedexapp.domain.model.Type

class Converters {
    @TypeConverter
    fun arrayListTypeToString(arrayList: ArrayList<Type>): String {
        return Gson().toJson(arrayList).toString()
    }

    @TypeConverter
    fun stringToArrayListType(string: String): ArrayList<Type> {
        val arrayListOfTypes = object : TypeToken<ArrayList<Type>>() {}.type
        return Gson().fromJson(string, arrayListOfTypes)
    }

    @TypeConverter
    fun arrayListStatToString(arrayList: ArrayList<Stat>): String {
        return Gson().toJson(arrayList).toString()
    }

    @TypeConverter
    fun stringToArrayListStat(string: String): ArrayList<Stat> {
        val arrayListOfTypes = object : TypeToken<ArrayList<Stat>>() {}.type
        return Gson().fromJson(string, arrayListOfTypes)
    }

    @TypeConverter
    fun arrayListAbilityToString(arrayList: ArrayList<Ability>): String {
        return Gson().toJson(arrayList).toString()
    }

    @TypeConverter
    fun stringToArrayListAbility(string: String): ArrayList<Ability> {
        val arrayListOfTypes = object : TypeToken<ArrayList<Ability>>() {}.type
        return Gson().fromJson(string, arrayListOfTypes)
    }

    @TypeConverter
    fun arrayListEggGroupToString(arrayList: ArrayList<EggGroup>): String {
        return Gson().toJson(arrayList).toString()
    }

    @TypeConverter
    fun stringToArrayListEggGroup(string: String): ArrayList<EggGroup> {
        val arrayListOfTypes = object : TypeToken<ArrayList<EggGroup>>() {}.type
        return Gson().fromJson(string, arrayListOfTypes)
    }
}