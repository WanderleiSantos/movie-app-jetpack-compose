package com.wanderlei.movieapp.movie_favorite_feature.di

import com.wanderlei.movieapp.core.data.local.dao.MovieDao
import com.wanderlei.movieapp.movie_favorite_feature.data.repository.MovieFavoriteRepositoryImpl
import com.wanderlei.movieapp.movie_favorite_feature.data.source.MovieFavoriteLocalDataSourceImpl
import com.wanderlei.movieapp.movie_favorite_feature.domain.repository.MovieFavoriteRepository
import com.wanderlei.movieapp.movie_favorite_feature.domain.source.MovieFavoriteLocalDataSource
import com.wanderlei.movieapp.movie_favorite_feature.domain.usecase.AddMovieFavoriteUseCase
import com.wanderlei.movieapp.movie_favorite_feature.domain.usecase.AddMovieFavoriteUseCaseImpl
import com.wanderlei.movieapp.movie_favorite_feature.domain.usecase.DeleteMovieFavoriteUseCase
import com.wanderlei.movieapp.movie_favorite_feature.domain.usecase.DeleteMovieFavoriteUseCaseImpl
import com.wanderlei.movieapp.movie_favorite_feature.domain.usecase.GetMoviesFavoriteUseCase
import com.wanderlei.movieapp.movie_favorite_feature.domain.usecase.GetMoviesFavoriteUseCaseImpl
import com.wanderlei.movieapp.movie_favorite_feature.domain.usecase.IsMovieFavoriteUseCase
import com.wanderlei.movieapp.movie_favorite_feature.domain.usecase.IsMovieFavoriteUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MovieFavoriteFeatureModule {

    @Provides
    @Singleton
    fun provideMovieFavoriteLocalDataSource(dao: MovieDao): MovieFavoriteLocalDataSource {
        return MovieFavoriteLocalDataSourceImpl(dao = dao)
    }

    @Provides
    @Singleton
    fun provideMovieFavoriteRepository(localDataSource: MovieFavoriteLocalDataSource): MovieFavoriteRepository {
        return MovieFavoriteRepositoryImpl(localDataSource = localDataSource)
    }

    @Provides
    @Singleton
    fun provideGetMoviesFavoriteUseCase(movieFavoriteRepository: MovieFavoriteRepository): GetMoviesFavoriteUseCase {
        return GetMoviesFavoriteUseCaseImpl(movieFavoriteRepository = movieFavoriteRepository)
    }

    @Provides
    @Singleton
    fun provideAddMoviesFavoriteUseCase(movieFavoriteRepository: MovieFavoriteRepository): AddMovieFavoriteUseCase {
        return AddMovieFavoriteUseCaseImpl(movieFavoriteRepository = movieFavoriteRepository)
    }


    @Provides
    @Singleton
    fun provideDeleteMoviesFavoriteUseCase(movieFavoriteRepository: MovieFavoriteRepository): DeleteMovieFavoriteUseCase {
        return DeleteMovieFavoriteUseCaseImpl(movieFavoriteRepository = movieFavoriteRepository)
    }


    @Provides
    @Singleton
    fun provideIsMoviesFavoriteUseCase(movieFavoriteRepository: MovieFavoriteRepository): IsMovieFavoriteUseCase {
        return IsMovieFavoriteUseCaseImpl(movieFavoriteRepository = movieFavoriteRepository)
    }
}