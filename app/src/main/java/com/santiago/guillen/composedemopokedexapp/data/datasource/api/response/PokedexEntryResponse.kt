package com.santiago.guillen.composedemopokedexapp.data.datasource.api.response

import com.google.gson.annotations.SerializedName

data class PokedexEntryResponse(
    @SerializedName("count")
    var count: Int,
    @SerializedName("next")
    var next: String,
    @SerializedName("previous")
    var previous: String,
    @SerializedName("results")
    var results: ArrayList<EntryResponse>
)

data class EntryResponse(
    @SerializedName("name")
    var name: String,
    @SerializedName("url")
    var url: String
)
