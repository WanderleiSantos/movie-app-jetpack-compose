package com.wanderlei.movieapp.search_movie_feature.domain.source

import com.wanderlei.movieapp.core.data.remote.response.SearchResponse
import com.wanderlei.movieapp.core.paging.MovieSearchPagingSource

interface MovieSearchRemoteDataSource {
    fun getSearchMoviePagingSources(query: String): MovieSearchPagingSource
    suspend fun getSearchMovies(page: Int, query: String): SearchResponse
}