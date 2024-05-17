package com.wanderlei.movieapp.movie_popular_feature.data.mapper

import com.wanderlei.movieapp.core.data.remote.model.MovieResult
import com.wanderlei.movieapp.core.domain.model.Movie
import com.wanderlei.movieapp.core.util.toPostUrl

fun List<MovieResult>.toMovie() = map { movieResult ->
    Movie(
        id = movieResult.id,
        title = movieResult.title,
        voteAverage = movieResult.voteAverage,
        imageUrl = movieResult.posterPath.toPostUrl()
    )
}