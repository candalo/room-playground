package com.github.roomplayground.presentation

import com.github.roomplayground.domain.Note


interface NotesView {
    fun showNotes(notes: List<Note>)
    fun openNote(note: Note)
}