package com.wanderlei.movieapp.movie_favorite_feature.data.source

import com.wanderlei.movieapp.core.data.local.dao.MovieDao
import com.wanderlei.movieapp.core.domain.model.Movie
import com.wanderlei.movieapp.movie_favorite_feature.data.mapper.toMovieEntity
import com.wanderlei.movieapp.movie_favorite_feature.data.mapper.toMovies
import com.wanderlei.movieapp.movie_favorite_feature.domain.source.MovieFavoriteLocalDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MovieFavoriteLocalDataSourceImpl @Inject constructor(
    private val dao: MovieDao
) : MovieFavoriteLocalDataSource {

    override fun getMovies(): Flow<List<Movie>> {
        return dao.getMovies().map {
            it.toMovies()
        }
    }

    override suspend fun insert(movie: Movie) {
        dao.insertMovie(movie.toMovieEntity())
    }

    override suspend fun delete(movie: Movie) {
        dao.deleteMovie(movie.toMovieEntity())
    }

    override suspend fun isFavorite(movieId: Int): Boolean {
        return dao.isFavorite(movieId) != null
    }
}