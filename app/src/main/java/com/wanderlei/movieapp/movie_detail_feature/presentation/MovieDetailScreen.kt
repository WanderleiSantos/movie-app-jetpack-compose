package com.wanderlei.movieapp.movie_detail_feature.presentation

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.res.stringResource
import androidx.paging.compose.collectAsLazyPagingItems
import com.wanderlei.movieapp.R
import com.wanderlei.movieapp.core.domain.model.Movie
import com.wanderlei.movieapp.movie_detail_feature.presentation.components.MovieDetailContent
import com.wanderlei.movieapp.movie_detail_feature.presentation.state.MovieDetailState
import com.wanderlei.movieapp.ui.theme.black
import com.wanderlei.movieapp.ui.theme.white

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MovieDetailScreen(
    id: Int?,
    uiState: MovieDetailState,
    onAddFavorite: (Movie) -> Unit,
    checkedFavorite: (MovieDetailEvent.CheckedFavorite) -> Unit,
    getMovieDetail: (MovieDetailEvent.GetMovieDetail) -> Unit
) {
    val pagingMoviesSimilar = uiState.results.collectAsLazyPagingItems()

    LaunchedEffect(key1 = true) {
        if (id != null) {
            getMovieDetail(MovieDetailEvent.GetMovieDetail(id))
            checkedFavorite(MovieDetailEvent.CheckedFavorite(id))
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(id = R.string.detail_movie), color = white)
                },
                backgroundColor = black
            )
        },
        content = {
            MovieDetailContent(
                movieDetails = uiState.movieDetails,
                pagingMoviesSimilar = pagingMoviesSimilar,
                isLoading = uiState.isLoading,
                isError = uiState.error,
                iconColor = uiState.iconColor,
                onAddFavorite = { movie -> onAddFavorite(movie) }
            )
        }
    )
}