package com.github.roomplayground.presentation

import com.github.roomplayground.domain.Note


class NotesPresenterImpl : NotesPresenter {

    private lateinit var view: NotesView

    override fun attachTo(view: NotesView) {
        this.view = view
    }

    override fun onNoteSelected(note: Note) {
        view.openNote(note)
    }
}