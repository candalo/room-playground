package com.github.roomplayground.presentation

import com.github.roomplayground.domain.Note


interface NoteView {
    fun onNoteSaved(note: Note)
}