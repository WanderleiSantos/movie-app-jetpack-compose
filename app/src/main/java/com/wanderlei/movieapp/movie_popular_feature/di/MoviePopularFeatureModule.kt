package com.wanderlei.movieapp.movie_popular_feature.di

import com.wanderlei.movieapp.core.data.remote.MovieService
import com.wanderlei.movieapp.movie_popular_feature.data.repository.MoviePopularRepositoryImpl
import com.wanderlei.movieapp.movie_popular_feature.data.source.MoviePopularRemoteDataSourceImpl
import com.wanderlei.movieapp.movie_popular_feature.domain.repository.MoviePopularRepository
import com.wanderlei.movieapp.movie_popular_feature.domain.source.MoviePopularRemoteDataSource
import com.wanderlei.movieapp.movie_popular_feature.domain.usecase.GetPopularMoviesUseCase
import com.wanderlei.movieapp.movie_popular_feature.domain.usecase.GetPopularMoviesUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MoviePopularFeatureModule {

    @Provides
    @Singleton
    fun provideMovieDataSource(service: MovieService): MoviePopularRemoteDataSource {
        return MoviePopularRemoteDataSourceImpl(service = service)
    }

    @Provides
    @Singleton
    fun provideMovieRepository(remoteDataSource: MoviePopularRemoteDataSource): MoviePopularRepository {
        return MoviePopularRepositoryImpl(remoteDataSource = remoteDataSource)
    }

    @Provides
    @Singleton
    fun provideGetMoviesPopularUseCase(moviePopularRepository: MoviePopularRepository): GetPopularMoviesUseCase {
        return GetPopularMoviesUseCaseImpl(repository = moviePopularRepository)
    }
}