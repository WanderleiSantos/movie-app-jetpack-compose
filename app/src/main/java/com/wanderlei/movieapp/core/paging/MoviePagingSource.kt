package com.wanderlei.movieapp.core.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.wanderlei.movieapp.core.domain.model.Movie
import com.wanderlei.movieapp.movie_popular_feature.data.mapper.toMovie
import com.wanderlei.movieapp.movie_popular_feature.domain.source.MoviePopularRemoteDataSource
import retrofit2.HttpException
import java.io.IOException

class MoviePagingSource constructor(
    private val remoteDataSource: MoviePopularRemoteDataSource
) : PagingSource<Int, Movie>() {
    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(LIMIT) ?: anchorPage?.nextKey?.minus(LIMIT)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        return try {
            val pageNumber = params.key ?: 1
            val response = remoteDataSource.getPopularMovies(page = pageNumber)
            val movies = response.results

            LoadResult.Page(
                data = movies.toMovie(),
                prevKey = if (pageNumber == 1) null else pageNumber - 1,
                nextKey = if (movies.isEmpty()) null else pageNumber + 1
            )
        } catch (ex: IOException) {
            ex.printStackTrace()
            return LoadResult.Error(ex)
        } catch (ex: HttpException) {
            ex.printStackTrace()
            return LoadResult.Error(ex)
        }
    }

    companion object {
        private const val LIMIT = 20
    }
}