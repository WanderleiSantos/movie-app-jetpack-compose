package com.wanderlei.movieapp.movie_favorite_feature.domain.source

import com.wanderlei.movieapp.core.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieFavoriteLocalDataSource {

    fun getMovies(): Flow<List<Movie>>
    suspend fun insert(movie: Movie)
    suspend fun delete(movie: Movie)
    suspend fun isFavorite(movieId: Int): Boolean
}