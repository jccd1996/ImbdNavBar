package com.example.imbdnavbar.domain.model

import com.google.gson.annotations.SerializedName


data class MoviesResponse(
    @SerializedName("page") var page: Int? = null,
    @SerializedName("results") var results: ArrayList<Results> = arrayListOf(),
    @SerializedName("total_pages") var totalPages: Int? = null,
    @SerializedName("total_results") var totalResults: Int? = null
)