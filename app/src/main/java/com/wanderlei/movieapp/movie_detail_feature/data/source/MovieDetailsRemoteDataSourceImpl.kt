package com.wanderlei.movieapp.movie_detail_feature.data.source

import com.wanderlei.movieapp.core.data.remote.MovieService
import com.wanderlei.movieapp.core.data.remote.response.MovieResponse
import com.wanderlei.movieapp.core.domain.model.MovieDetails
import com.wanderlei.movieapp.core.paging.MovieSimilarPagingSource
import com.wanderlei.movieapp.core.util.toBackdropUrl
import com.wanderlei.movieapp.movie_detail_feature.domain.source.MovieDetailsRemoteDataSource
import javax.inject.Inject

class MovieDetailsRemoteDataSourceImpl @Inject constructor(
    private val service: MovieService
) : MovieDetailsRemoteDataSource {
    override suspend fun getMovieDetails(movieId: Int): MovieDetails {
        val response = service.getMovie(movieId)
        val genres = response.genres.map { it.name }
        return MovieDetails(
            id = response.id,
            title = response.title,
            overview = response.overview,
            genres = genres,
            releaseDate = response.releaseDate,
            backdropPathUrl = response.backdropPath.toBackdropUrl(),
            voteAverage = response.voteAverage,
            duration = response.runtime,
            voteCount = response.voteCount
        )
    }

    override suspend fun getMoviesSimilar(page: Int, movieId: Int): MovieResponse {
        return service.getMoviesSimilar(page = page, movieId = movieId)
    }

    override fun getSimilarMoviesPagingSource(movieId: Int): MovieSimilarPagingSource {
        return MovieSimilarPagingSource(this, movieId = movieId)
    }
}