package com.onirutla.movflex.data.repository.movie

import android.util.Log
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.onirutla.movflex.data.source.remote.PagingDataSource
import com.onirutla.movflex.data.source.remote.response.ItemResponse
import com.onirutla.movflex.data.source.remote.response.movie.MovieResponseDetail
import com.onirutla.movflex.data.source.remote.service.MovieApiService
import com.onirutla.movflex.util.Constants.NETWORK_LOAD_SIZE
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val movieApiService: MovieApiService
) : MovieRepository {

    override fun getMoviePopularPaging(): Flow<PagingData<ItemResponse>> = Pager(
        config = PagingConfig(pageSize = NETWORK_LOAD_SIZE, enablePlaceholders = false),
        pagingSourceFactory = {
            PagingDataSource { position -> movieApiService.getMoviePopular(position) }
        },
    ).flow

    override fun getMoviePopularHome(): Flow<List<ItemResponse>> = flow {
        try {
            val response = movieApiService.getMoviePopular()
            if (response.isSuccessful)
                emit(response.body()!!.results)
            else
                emit(emptyList())
        } catch (ioException: IOException) {
            Log.d("MovieRepo", "$ioException")
            emit(emptyList())
        } catch (httpException: HttpException) {
            Log.d("MovieRepo", "$httpException")
            emit(emptyList())
        }
    }

    override fun getMovieNowPlayingPaging(): Flow<PagingData<ItemResponse>> = Pager(
        config = PagingConfig(pageSize = NETWORK_LOAD_SIZE, enablePlaceholders = false),
        pagingSourceFactory = {
            PagingDataSource { position -> movieApiService.getMovieNowPlaying(position) }
        },
    ).flow

    override fun getMovieNowPlayingHome(): Flow<List<ItemResponse>> = flow {
        try {
            val response = movieApiService.getMovieNowPlaying()
            if (response.isSuccessful)
                emit(response.body()!!.results)
            else
                emit(emptyList())
        } catch (ioException: IOException) {
            Log.d("MovieRepo", "$ioException")
            emit(emptyList())
        } catch (httpException: HttpException) {
            Log.d("MovieRepo", "$httpException")
            emit(emptyList())
        }
    }

    override fun getMovieTopRatedPaging(): Flow<PagingData<ItemResponse>> = Pager(
        config = PagingConfig(pageSize = NETWORK_LOAD_SIZE, enablePlaceholders = false),
        pagingSourceFactory = {
            PagingDataSource { position -> movieApiService.getMovieTopRated(position) }
        }
    ).flow

    override fun getMovieTopRatedHome(): Flow<List<ItemResponse>> = flow {
        try {
            val response = movieApiService.getMovieTopRated()
            if (response.isSuccessful)
                emit(response.body()!!.results)
            else
                emit(emptyList())
        } catch (ioException: IOException) {
            Log.d("MovieRepo", "$ioException")
            emit(emptyList())
        } catch (httpException: HttpException) {
            Log.d("MovieRepo", "$httpException")
            emit(emptyList())
        }
    }

    override fun getMovieUpcomingPaging(): Flow<PagingData<ItemResponse>> = Pager(
        config = PagingConfig(pageSize = NETWORK_LOAD_SIZE, enablePlaceholders = false),
        pagingSourceFactory = {
            PagingDataSource { position -> movieApiService.getMovieUpcoming(position) }
        }
    ).flow

    override fun getMovieUpcomingHome(): Flow<List<ItemResponse>> = flow {
        try {
            val response = movieApiService.getMovieUpcoming()
            if (response.isSuccessful)
                emit(response.body()!!.results)
            else
                emit(emptyList())
        } catch (ioException: IOException) {
            Log.d("MovieRepo", "$ioException")
            emit(emptyList())
        } catch (httpException: HttpException) {
            Log.d("MovieRepo", "$httpException")
            emit(emptyList())
        }
    }

    override fun getMovieDetail(): Flow<MovieResponseDetail> {
        TODO("Not yet implemented")
    }
}