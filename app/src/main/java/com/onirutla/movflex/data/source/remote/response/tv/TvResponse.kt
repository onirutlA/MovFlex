package com.onirutla.movflex.data.source.remote.response.tv

import com.onirutla.movflex.data.source.local.entities.TvEntity
import com.squareup.moshi.Json

data class TvResponse(
    @Json(name = "backdrop_path")
    val backdropPath: String = "",
    @Json(name = "first_air_date")
    val firstAirDate: String = "",
    @Json(name = "genre_ids")
    val genreIds: List<Int> = listOf(),
    @Json(name = "id")
    val id: Int = 0,
    @Json(name = "name")
    val name: String = "",
    @Json(name = "origin_country")
    val originCountry: List<String> = listOf(),
    @Json(name = "original_language")
    val originalLanguage: String = "",
    @Json(name = "original_name")
    val originalName: String = "",
    @Json(name = "overview")
    val overview: String = "",
    @Json(name = "popularity")
    val popularity: Double = 0.0,
    @Json(name = "poster_path")
    val posterPath: String = "",
    @Json(name = "vote_average")
    val voteAverage: Double = 0.0,
    @Json(name = "vote_count")
    val voteCount: Int = 0
)

fun TvResponse.toEntity() = TvEntity(
    backdropPath,
    firstAirDate,
    genreIds,
    id,
    name,
    originCountry,
    originalLanguage,
    originalName,
    overview,
    popularity,
    posterPath,
    voteAverage,
    voteCount
)