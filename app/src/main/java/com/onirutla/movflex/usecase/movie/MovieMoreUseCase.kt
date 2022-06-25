package com.onirutla.movflex.usecase.movie

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import com.onirutla.movflex.data.repository.movie.MovieRepository
import com.onirutla.movflex.data.source.remote.response.ItemDto
import com.onirutla.movflex.util.MovieType
import javax.inject.Inject

class MovieMoreUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {

    operator fun invoke(movieType: MovieType): LiveData<PagingData<ItemDto>> =
        when (movieType) {
            MovieType.MOVIE_UPCOMING -> movieRepository.getMovieUpcomingPaging()
            MovieType.MOVIE_TOP_RATED -> movieRepository.getMovieTopRatedPaging()
            MovieType.MOVIE_NOW_PLAYING -> movieRepository.getMovieNowPlayingPaging()
            MovieType.MOVIE_POPULAR -> movieRepository.getMoviePopularPaging()
        }

}