package com.onirutla.movflex.data.remote.response.tv

import com.onirutla.movflex.data.remote.response.detail.Genre
import com.onirutla.movflex.data.remote.response.detail.ProductionCompany
import com.onirutla.movflex.data.remote.response.detail.ProductionCountry
import com.onirutla.movflex.data.remote.response.detail.SpokenLanguage
import com.onirutla.movflex.data.remote.response.detail.CreatedBy
import com.onirutla.movflex.data.remote.response.detail.LastEpisodeToAir
import com.onirutla.movflex.data.remote.response.detail.Network
import com.onirutla.movflex.data.remote.response.detail.Season
import com.squareup.moshi.Json

data class TvResponseDetail(
    @Json(name = "backdrop_path")
    val backdropPath: String = "",
    @Json(name = "created_by")
    val createdBy: List<CreatedBy> = listOf(),
    @Json(name = "episode_run_time")
    val episodeRunTime: List<Int> = listOf(),
    @Json(name = "first_air_date")
    val firstAirDate: String = "",
    @Json(name = "genres")
    val genres: List<Genre> = listOf(),
    @Json(name = "homepage")
    val homepage: String = "",
    @Json(name = "id")
    val id: Int = 0,
    @Json(name = "in_production")
    val inProduction: Boolean = false,
    @Json(name = "languages")
    val languages: List<String> = listOf(),
    @Json(name = "last_air_date")
    val lastAirDate: String = "",
    @Json(name = "last_episode_to_air")
    val lastEpisodeToAir: LastEpisodeToAir = LastEpisodeToAir(),
    @Json(name = "name")
    val name: String = "",
    @Json(name = "networks")
    val networks: List<Network> = listOf(),
    @Json(name = "next_episode_to_air")
    val nextEpisodeToAir: Any = Any(),
    @Json(name = "number_of_episodes")
    val numberOfEpisodes: Int = 0,
    @Json(name = "number_of_seasons")
    val numberOfSeasons: Int = 0,
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
    @Json(name = "production_companies")
    val productionCompanies: List<ProductionCompany> = listOf(),
    @Json(name = "production_countries")
    val productionCountries: List<ProductionCountry> = listOf(),
    @Json(name = "seasons")
    val seasons: List<Season> = listOf(),
    @Json(name = "spoken_languages")
    val spokenLanguages: List<SpokenLanguage> = listOf(),
    @Json(name = "status")
    val status: String = "",
    @Json(name = "tagline")
    val tagline: String = "",
    @Json(name = "type")
    val type: String = "",
    @Json(name = "vote_average")
    val voteAverage: Double = 0.0,
    @Json(name = "vote_count")
    val voteCount: Int = 0
)