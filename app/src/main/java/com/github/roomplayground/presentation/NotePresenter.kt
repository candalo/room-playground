package com.github.roomplayground.presentation

import com.github.roomplayground.domain.Note


interface NotePresenter : Presenter<NoteView> {
    fun onSaveNoteOptionSelected(note: Note, isUpdate: Boolean)
}