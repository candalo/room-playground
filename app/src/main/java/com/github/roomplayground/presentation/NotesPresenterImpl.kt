package com.github.roomplayground.presentation

import com.github.roomplayground.domain.Note
import com.github.roomplayground.domain.UseCase
import com.github.roomplayground.domain.UseCaseResult


class NotesPresenterImpl(
        private val getNotesUseCase: UseCase<Unit, List<Note>>
) : NotesPresenter, UseCaseResult<List<Note>> {

    private lateinit var view: NotesView

    override fun attachTo(view: NotesView) {
        this.view = view
        executeUseCase()
    }

    private fun executeUseCase() {
        getNotesUseCase.execute(Unit, this)
    }

    override fun getUseCaseResult(result: List<Note>) {
        if (result.isEmpty()) {
            view.showEmptyNotesInfo()
            return
        }
        view.hideEmptyNotesInfo()
        view.showNotes(result)
    }

    override fun onNoteSelected(note: Note) {
        view.openNote(note)
    }

}