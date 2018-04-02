package com.github.roomplayground.presentation

import com.github.roomplayground.domain.Note


interface NotesPresenter : Presenter<NotesView> {
    fun onNoteSelected(note: Note)
}