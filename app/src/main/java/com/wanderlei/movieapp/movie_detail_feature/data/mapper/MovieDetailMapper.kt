package com.wanderlei.movieapp.movie_detail_feature.data.mapper

import com.wanderlei.movieapp.core.domain.model.Movie
import com.wanderlei.movieapp.core.domain.model.MovieDetails

fun MovieDetails.toMovie(): Movie {
    return Movie(
        id = id,
        title = title,
        imageUrl = backdropPathUrl.toString(),
        voteAverage = voteAverage
    )
}