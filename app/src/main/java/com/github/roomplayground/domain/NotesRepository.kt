package com.github.roomplayground.domain


interface NotesRepository {
    fun getList(): List<Note>
}