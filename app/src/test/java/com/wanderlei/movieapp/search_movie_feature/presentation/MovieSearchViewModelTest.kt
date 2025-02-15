package com.wanderlei.movieapp.search_movie_feature.presentation

import androidx.paging.PagingData
import com.google.common.truth.Truth.assertThat
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.whenever
import com.wanderlei.movieapp.TestDispatcherRule
import com.wanderlei.movieapp.core.domain.model.MovieSearchFactory
import com.wanderlei.movieapp.search_movie_feature.domain.usecase.GetMovieSearchUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class MovieSearchViewModelTest {

    @get:Rule
    var mainCoroutineRule = TestDispatcherRule()

    @Mock
    lateinit var getMovieSearchUseCase: GetMovieSearchUseCase

    private val viewModel by lazy {
        MovieSearchViewModel(getMovieSearchUseCase)
    }

    private val fakePagingDataSearchMovies = PagingData.from(
        listOf(
            MovieSearchFactory().create(MovieSearchFactory.Poster.Avengers),
            MovieSearchFactory().create(MovieSearchFactory.Poster.JohnWick)
        )
    )

    @Test
    fun `must validate paging data object values when calling movie search paging data`() =
        runTest {

            whenever(getMovieSearchUseCase.invoke(any())).thenReturn(
                flowOf(fakePagingDataSearchMovies)
            )

            viewModel.fetch("")
            val result = viewModel.uiState.movies.first()

            assertThat(result).isNotNull()

        }

    @Test(expected = RuntimeException::class)
    fun `must throw an exception when the calling to the use case returns an exception`() =
        runTest {
            whenever(getMovieSearchUseCase.invoke(any())).thenThrow(RuntimeException())

            viewModel.fetch("")

        }

}