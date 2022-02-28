package com.santiago.guillen.composedemopokedexapp.data.datasource.api.response

import com.google.gson.annotations.SerializedName

data class VersionResponse(
    @SerializedName("name") var name: String? = null,
    @SerializedName("url") var url: String? = null
)
