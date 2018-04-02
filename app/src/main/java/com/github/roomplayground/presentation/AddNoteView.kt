package com.github.roomplayground.presentation

import com.github.roomplayground.domain.Note


interface AddNoteView {
    fun onNoteSaved(note: Note)
}