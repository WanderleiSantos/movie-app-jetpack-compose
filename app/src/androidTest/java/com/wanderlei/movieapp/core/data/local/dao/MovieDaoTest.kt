package com.wanderlei.movieapp.core.data.local.dao

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.filters.SmallTest
import com.google.common.truth.Truth.assertThat
import com.wanderlei.movieapp.core.data.local.MovieDatabase
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
    fun getMovies() = runTest {
        // Given - Nothing

        //When
        val movies = movieDao.getMovies().first()
        //Then
        assertThat(movies.size).isEqualTo(0)
    }
}