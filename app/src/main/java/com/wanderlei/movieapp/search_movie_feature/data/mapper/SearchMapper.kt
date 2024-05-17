package com.wanderlei.movieapp.search_movie_feature.data.mapper

import com.wanderlei.movieapp.core.data.remote.model.SearchResult
import com.wanderlei.movieapp.core.domain.model.MovieSearch
import com.wanderlei.movieapp.core.util.toPostUrl

fun List<SearchResult>.toMovieSearch() = map { searchResult ->
    MovieSearch(
        id = searchResult.id,
        imageUrl = searchResult.posterPath.toPostUrl(),
        voteAverage = searchResult.voteAverage
    )
}