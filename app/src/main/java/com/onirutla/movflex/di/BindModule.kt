package com.onirutla.movflex.di

import com.onirutla.movflex.data.repository.favorite.FavoriteRepository
import com.onirutla.movflex.data.repository.favorite.FavoriteRepositoryImpl
import com.onirutla.movflex.data.repository.movie.MovieRepository
import com.onirutla.movflex.data.repository.movie.MovieRepositoryImpl
import com.onirutla.movflex.data.repository.tv.TvRepository
import com.onirutla.movflex.data.repository.tv.TvRepositoryImpl
import com.onirutla.movflex.data.source.remote.movie.MovieRemoteDataSource
import com.onirutla.movflex.data.source.remote.movie.MovieRemoteDataSourceImpl
import com.onirutla.movflex.data.source.remote.tv.TvRemoteDataSource
import com.onirutla.movflex.data.source.remote.tv.TvRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class BindModule {

    @Binds
    @ViewModelScoped
    abstract fun bindMovieRepository(repositoryImpl: MovieRepositoryImpl): MovieRepository

    @Binds
    @ViewModelScoped
    abstract fun bindTvRepository(repositoryImpl: TvRepositoryImpl): TvRepository

    @Binds
    @ViewModelScoped
    abstract fun bindFavoriteRepository(repositoryImpl: FavoriteRepositoryImpl): FavoriteRepository

    @Binds
    @ViewModelScoped
    abstract fun bindMovieRemoteDataSource(remoteDataSourceImpl: MovieRemoteDataSourceImpl): MovieRemoteDataSource

    @Binds
    @ViewModelScoped
    abstract fun bindTvRemoteDataSource(remoteDataSourceImpl: TvRemoteDataSourceImpl): TvRemoteDataSource
}