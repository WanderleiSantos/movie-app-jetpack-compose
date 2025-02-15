package com.wanderlei.movieapp.core.domain.model

class MovieFactory {

    fun create(poster: Poster) = when (poster) {
        Poster.Avengers -> {
            Movie(
                id = 1,
                title = "Avengers",
                voteAverage = 7.1,
                imageUrl = "url"
            )
        }

        Poster.JohnWick -> {
            Movie(
                id = 1,
                title = "John Wick",
                voteAverage = 9.1,
                imageUrl = "url"
            )
        }
    }

    sealed class Poster {
        data object Avengers : Poster()
        data object JohnWick : Poster()
    }
}