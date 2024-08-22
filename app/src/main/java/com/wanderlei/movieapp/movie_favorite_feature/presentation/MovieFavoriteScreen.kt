package com.wanderlei.movieapp.movie_favorite_feature.presentation

import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.wanderlei.movieapp.R
import com.wanderlei.movieapp.movie_favorite_feature.presentation.components.MovieFavoriteContent
import com.wanderlei.movieapp.movie_favorite_feature.presentation.state.MovieFavoriteState
import com.wanderlei.movieapp.ui.theme.black
import com.wanderlei.movieapp.ui.theme.white

@Composable
fun MovieFavoriteScreen(
    uiState: MovieFavoriteState,
    navigateToDetailMovie: (Int) -> Unit
) {
    val movies = uiState.movies

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.favorite_movies),
                        color = white
                    )
                },
                backgroundColor = black
            )
        },
        content = { paddingValues ->
            MovieFavoriteContent(
                paddingValues = paddingValues,
                movies = movies,
                onClick = { movieId ->
                    navigateToDetailMovie(movieId)
                }
            )
        }
    )
}

@Preview
@Composable
fun MovieFavoriteScreenPreview(){
    MovieFavoriteScreen(uiState = MovieFavoriteState(), navigateToDetailMovie = {})
}