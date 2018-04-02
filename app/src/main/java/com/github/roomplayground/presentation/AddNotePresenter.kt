package com.github.roomplayground.presentation


interface AddNotePresenter : Presenter<AddNoteView> {
    fun onSaveNoteOptionSelected(noteText: String)
}