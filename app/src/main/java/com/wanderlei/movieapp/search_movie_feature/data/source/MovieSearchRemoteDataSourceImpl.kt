package com.wanderlei.movieapp.search_movie_feature.data.source

import com.wanderlei.movieapp.core.data.remote.MovieService
import com.wanderlei.movieapp.core.data.remote.response.SearchResponse
import com.wanderlei.movieapp.core.paging.MovieSearchPagingSource
import com.wanderlei.movieapp.search_movie_feature.domain.source.MovieSearchRemoteDataSource
import javax.inject.Inject

class MovieSearchRemoteDataSourceImpl @Inject constructor(
    private val service: MovieService
) : MovieSearchRemoteDataSource {
    override fun getSearchMoviePagingSources(query: String): MovieSearchPagingSource {
        return MovieSearchPagingSource(query = query, remoteDataSource = this)
    }

    override suspend fun getSearchMovies(page: Int, query: String): SearchResponse {
        return service.searchMovie(page = page, query = query)
    }
}