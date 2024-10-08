package com.wanderlei.movieapp.movie_favorite_feature.domain.usecase

import com.wanderlei.movieapp.core.domain.model.Movie
import com.wanderlei.movieapp.movie_favorite_feature.domain.repository.MovieFavoriteRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


interface GetMoviesFavoriteUseCase {
    suspend operator fun invoke(): Flow<List<Movie>>
}

class GetMoviesFavoriteUseCaseImpl @Inject constructor(
    private val movieFavoriteRepository: MovieFavoriteRepository
) : GetMoviesFavoriteUseCase {

    override suspend fun invoke(): Flow<List<Movie>> {
        return movieFavoriteRepository.getMovies()
    }
}