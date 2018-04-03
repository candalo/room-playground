package com.github.roomplayground.presentation

import com.github.roomplayground.domain.Note
import com.github.roomplayground.domain.UseCase
import com.github.roomplayground.domain.UseCaseResult
import com.github.roomplayground.util.DateUtil
import java.util.Date


class AddNotePresenterImpl(
        private val saveNoteUseCase: UseCase<Note, Note>
) : AddNotePresenter, UseCaseResult<Note> {

    private lateinit var view: AddNoteView

    override fun attachTo(view: AddNoteView) {
        this.view = view
    }

    override fun onSaveNoteOptionSelected(noteText: String) {
        saveNoteUseCase.execute(Note(text = noteText, date = DateUtil.getDateInFull(Date())), this)
    }

    override fun getUseCaseResult(result: Note) {
        view.onNoteSaved(result)
    }
}