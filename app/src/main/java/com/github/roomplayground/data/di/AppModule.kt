package com.github.roomplayground.data.di

import android.arch.persistence.room.Room
import android.content.Context
import com.github.roomplayground.data.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val context: Context) {
    companion object {
        const val DB_NAME = "notes-db"
    }

    @Provides
    @Singleton
    fun provideAppDatabase(): AppDatabase =
            Room.databaseBuilder(context, AppDatabase::class.java, DB_NAME).build()
}