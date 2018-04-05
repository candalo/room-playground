package com.github.roomplayground.presentation

import com.github.roomplayground.domain.Note
import com.github.roomplayground.domain.UseCase
import com.github.roomplayground.domain.UseCaseResult


class NotePresenterImpl(
        private val saveNoteUseCase: UseCase<Note, Note>,
        private val updateNoteUseCase: UseCase<Note, Note>
) : NotePresenter, UseCaseResult<Note> {

    private lateinit var view: NoteView

    override fun attachTo(view: NoteView) {
        this.view = view
    }

    override fun onSaveNoteOptionSelected(note: Note, isUpdate: Boolean) {
        when (isUpdate) {
            true -> updateNoteUseCase.execute(note, this)
            false -> saveNoteUseCase.execute(note, this)
        }
    }

    override fun getUseCaseResult(result: Note) {
        view.onNoteSaved(result)
    }
}