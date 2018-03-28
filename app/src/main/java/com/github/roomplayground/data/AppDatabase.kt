package com.github.roomplayground.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.github.roomplayground.domain.Note

@Database(entities = [Note::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao
}