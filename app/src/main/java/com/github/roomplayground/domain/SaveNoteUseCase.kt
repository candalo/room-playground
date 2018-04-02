package com.github.roomplayground.domain

import kotlinx.coroutines.experimental.async


class SaveNoteUseCase(private val repository: NotesRepository) : UseCase<Note, Note> {
    override fun execute(params: Note, listener: UseCaseResult<Note>) {
        async {
            repository.save(params)
            listener.getUseCaseResult(params)
        }
    }
}