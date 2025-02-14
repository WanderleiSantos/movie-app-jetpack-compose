package com.wanderlei.movieapp.core.data.local.dao

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.filters.SmallTest
import com.google.common.truth.Truth.assertThat
import com.wanderlei.movieapp.core.data.local.MovieDatabase
import com.wanderlei.movieapp.core.data.local.entity.MovieEntity
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import jakarta.inject.Inject
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Named

@HiltAndroidTest
@SmallTest
class MovieDaoTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Inject
    @Named("test_db")
    lateinit var database: MovieDatabase

    private lateinit var movieDao: MovieDao

    @Before
    fun setup(){
        hiltRule.inject()
        movieDao = database.movieDao()
    }

    @After
    fun tearDown(){
        database.close()
    }

    @Test
    fun test_getMovies_should_return_list_of_movies() = runTest {
        val movies = movieDao.getMovies().first()
        assertThat(movies.size).isEqualTo(0)
    }

    @Test
    fun test_getMovies_should_return_list_of_ordered_by_id() = runTest {
        val moviesEntities = listOf(
            MovieEntity(movieId = 1, title = "Nome 1", imageUrl = "url1"),
            MovieEntity(movieId = 3, title = "Nome 3", imageUrl = "url3"),
            MovieEntity(movieId = 5, title = "Nome 5", imageUrl = "url5"),
            MovieEntity(movieId = 4, title = "Nome 4", imageUrl = "url4"),
            MovieEntity(movieId = 2, title = "Nome 2", imageUrl = "url2")
        )
        movieDao.insertMovies(moviesEntities)

        val movies = movieDao.getMovies().first()

        assertThat(movies.size).isEqualTo(5)
        assertThat(movies[0].movieId).isEqualTo(1)
        assertThat(movies[3].movieId).isEqualTo(4)
        assertThat(movies[4].movieId).isEqualTo(5)
    }

    @Test
    fun test_getMovie_should_return_correct_movie_by_id() = runTest {
        val moviesEntities = listOf(
            MovieEntity(movieId = 1, title = "Nome 1", imageUrl = "url1"),
            MovieEntity(movieId = 3, title = "Nome 3", imageUrl = "url3"),
            MovieEntity(movieId = 5, title = "Nome 5", imageUrl = "url5"),
            MovieEntity(movieId = 4, title = "Nome 4", imageUrl = "url4"),
            MovieEntity(movieId = 2, title = "Nome 2", imageUrl = "url2")
        )
        movieDao.insertMovies(moviesEntities)

        val movie = movieDao.getMovie(5)

        assertThat(movie).isNotNull()
        assertThat(movie?.movieId).isEqualTo(5)
        assertThat(movie?.title).isEqualTo("Nome 5")
    }
}