package com.wanderlei.movieapp.movie_favorite_feature.presentation.state

import com.wanderlei.movieapp.core.domain.model.Movie

data class MovieFavoriteState(
    val movies: List<Movie> = emptyList()
)
