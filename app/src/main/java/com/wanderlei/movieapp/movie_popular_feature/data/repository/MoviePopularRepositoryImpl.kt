package com.wanderlei.movieapp.movie_popular_feature.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.wanderlei.movieapp.core.domain.model.Movie
import com.wanderlei.movieapp.movie_popular_feature.domain.repository.MoviePopularRepository
import com.wanderlei.movieapp.movie_popular_feature.domain.source.MoviePopularRemoteDataSource
import kotlinx.coroutines.flow.Flow

class MoviePopularRepositoryImpl constructor(
    private val remoteDataSource: MoviePopularRemoteDataSource
) : MoviePopularRepository {
    override fun getPopularMovies(pagingConfig: PagingConfig): Flow<PagingData<Movie>> {
        return Pager(
            config = pagingConfig,
            pagingSourceFactory = {
                remoteDataSource.getPopularMoviesPagingSource()
            }
        ).flow
    }
}