package com.onirutla.movflex.source.remote.response.detail

import com.squareup.moshi.Json

data class PageResponse<T>(
    @Json(name = "page")
    val page: Int = 0,
    @Json(name = "results")
    val results: List<T> = listOf(),
    @Json(name = "total_pages")
    val totalPages: Int = 0,
    @Json(name = "total_results")
    val totalResults: Int = 0
)