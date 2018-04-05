package com.github.roomplayground.domain

import kotlinx.coroutines.experimental.async


class UpdateNoteUseCase(private val repository: NotesRepository) : UseCase<Note, Note> {
    override fun execute(params: Note, listener: UseCaseResult<Note>) {
        async {
            repository.update(params)
            listener.getUseCaseResult(params)
        }
    }
}