package com.wanderlei.movieapp.core.domain.model

class MovieSearchFactory {

    fun create(poster: Poster) = when (poster) {
        Poster.Avengers -> {
            MovieSearch(
                id = 1,
                voteAverage = 7.1,
                imageUrl = "url"
            )
        }

        Poster.JohnWick -> {
            MovieSearch(
                id = 1,
                voteAverage = 7.9,
                imageUrl = "url"
            )
        }
    }

    sealed class Poster {
        data object Avengers : Poster()
        data object JohnWick : Poster()
    }
}