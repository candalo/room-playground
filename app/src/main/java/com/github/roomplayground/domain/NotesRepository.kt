package com.github.roomplayground.domain


interface NotesRepository {
    fun getList(): List<Note>
    fun save(note: Note)
    fun update(note: Note)
}