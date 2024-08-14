package com.wanderlei.movieapp.movie_favorite_feature.data.mapper

import com.wanderlei.movieapp.core.data.local.entity.MovieEntity
import com.wanderlei.movieapp.core.domain.model.Movie

fun List<MovieEntity>.toMovies() = map { movieEntity ->
    Movie(
        id = movieEntity.movieId,
        title = movieEntity.title,
        imageUrl = movieEntity.imageUrl
    )
}

fun Movie.toMovieEntity(): MovieEntity {
    return MovieEntity(
        movieId = id,
        title = title,
        imageUrl = imageUrl
    )
}