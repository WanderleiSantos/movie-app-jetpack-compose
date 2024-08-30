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
import com.wanderlei.movieapp.core.presentation.components.common.MovieAppBar
import com.wanderlei.movieapp.movie_detail_feature.presentation.components.MovieDetailContent
import com.wanderlei.movieapp.movie_detail_feature.presentation.state.MovieDetailState
import com.wanderlei.movieapp.ui.theme.black
import com.wanderlei.movieapp.ui.theme.white

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MovieDetailScreen(
    uiState: MovieDetailState,
    onAddFavorite: (Movie) -> Unit,
) {
    val pagingMoviesSimilar = uiState.results.collectAsLazyPagingItems()

    Scaffold(
        topBar = {
            MovieAppBar(title = R.string.detail_movie)
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