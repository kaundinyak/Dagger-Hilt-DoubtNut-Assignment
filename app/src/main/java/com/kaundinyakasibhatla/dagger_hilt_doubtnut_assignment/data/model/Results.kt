package com.kaundinyakasibhatla.dagger_hilt_doubtnut_assignment.data.model

import com.squareup.moshi.Json
data class Results<T>(
    val page:Int, val  results:List<T>
)

data class Movie(
    @Json(name = "id")
    val id: Int = 0,
    @Json(name = "title")
    val title: String = "",
    @Json(name = "overview")
    val overview: String = "",
    @Json(name = "poster_path")
    val poster_path: String = ""

)