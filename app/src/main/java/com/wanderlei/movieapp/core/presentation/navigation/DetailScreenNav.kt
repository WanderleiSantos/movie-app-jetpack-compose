package com.wanderlei.movieapp.core.presentation.navigation

import com.wanderlei.movieapp.core.util.Constants.MOVIE_DETAIL_ARGUMENT_KEY

sealed class DetailScreenNav(val route: String) {
    object DetailScreen: DetailScreenNav(
        route = "movie_Detail_destination?$MOVIE_DETAIL_ARGUMENT_KEY={$MOVIE_DETAIL_ARGUMENT_KEY}"
    ) {
        fun passMovieId(movieId: Int) = "movie_Detail_destination?$MOVIE_DETAIL_ARGUMENT_KEY=$movieId"
    }
}