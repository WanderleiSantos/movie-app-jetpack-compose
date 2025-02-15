package com.wanderlei.movieapp.movie_popular_feature.presentation

import androidx.paging.PagingData
import com.google.common.truth.Truth.assertThat
import com.nhaarman.mockitokotlin2.whenever
import com.wanderlei.movieapp.TestDispatcherRule
import com.wanderlei.movieapp.core.domain.model.MovieFactory
import com.wanderlei.movieapp.movie_popular_feature.domain.usecase.GetPopularMoviesUseCase
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
class MoviePopularViewModelTest {

    @get:Rule
    var mainCoroutineRule = TestDispatcherRule()

    @Mock
    lateinit var getPopularMoviesUseCase: GetPopularMoviesUseCase

    private val viewModel by lazy {
        MoviePopularViewModel(getPopularMoviesUseCase)
    }

    private val fakePagingDataMovies = PagingData.from(
        listOf(
            MovieFactory().create(MovieFactory.Poster.Avengers),
            MovieFactory().create(MovieFactory.Poster.JohnWick)
        )
    )

    @Test
    fun `must validate paging data object values when calling paging data from movies`() = runTest {

        //Given
        whenever(getPopularMoviesUseCase()).thenReturn(
            flowOf(fakePagingDataMovies)
        )

        //When
        val result = viewModel.uiState.movies.first()

        //Then
        assertThat(result).isNotNull()

    }

    @Test(expected = RuntimeException::class)
    fun `must throw an exception when the calling to the use case returns an exception`() = runTest {
        whenever(getPopularMoviesUseCase.invoke()).thenThrow(RuntimeException())

          val result = viewModel.uiState.movies.first()
            assertThat(result).isNull()
    }
}

