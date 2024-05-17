package com.wanderlei.movieapp.movie_popular_feature.data.source

import com.wanderlei.movieapp.core.data.remote.MovieService
import com.wanderlei.movieapp.core.data.remote.response.MovieResponse
import com.wanderlei.movieapp.core.paging.MoviePagingSource
import com.wanderlei.movieapp.movie_popular_feature.domain.source.MoviePopularRemoteDataSource
import javax.inject.Inject

class MoviePopularRemoteDataSourceImpl @Inject constructor(
    private val service: MovieService
) : MoviePopularRemoteDataSource {

    override fun getPopularMoviesPagingSource(): MoviePagingSource {
        return MoviePagingSource(this)
    }

    override suspend fun getPopularMovies(page: Int): MovieResponse {
        return service.getPopularMovies(page = page)
    }
}