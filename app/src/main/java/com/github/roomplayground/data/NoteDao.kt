package com.github.roomplayground.data

import android.arch.persistence.room.*
import com.github.roomplayground.domain.Note

@Dao
interface NoteDao {
    @Query("SELECT * FROM notes")
    fun getAll(): List<Note>

    @Insert
    fun insert(note: Note)

    @Update
    fun update(note: Note)

    @Delete
    fun delete(note: Note)
}