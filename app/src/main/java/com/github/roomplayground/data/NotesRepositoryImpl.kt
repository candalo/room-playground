package com.github.roomplayground.data

import com.github.roomplayground.domain.Note
import com.github.roomplayground.domain.NotesRepository


class NotesRepositoryImpl(private val noteDao : NoteDao) : NotesRepository {
    override fun getList(): List<Note> = noteDao.getAll()
    override fun save(note: Note) = noteDao.insert(note)
}