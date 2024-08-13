package com.wanderlei.movieapp.core.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.wanderlei.movieapp.core.data.local.dao.MovieDao

@Database(
    entities = [MovieDatabase::class],
    version = 1,
    exportSchema = false
)
abstract class MovieDatabase: RoomDatabase() {

    abstract fun movieDao(): MovieDao
}