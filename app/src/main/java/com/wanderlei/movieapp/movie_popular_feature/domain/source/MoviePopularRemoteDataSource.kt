package com.wanderlei.movieapp.movie_popular_feature.domain.source

import com.wanderlei.movieapp.core.data.remote.response.MovieResponse
import com.wanderlei.movieapp.core.paging.MoviePagingSource

interface MoviePopularRemoteDataSource {

    fun getPopularMoviesPagingSource(): MoviePagingSource
    suspend fun getPopularMovies(page: Int): MovieResponse
}