package com.github.roomplayground.domain

import kotlinx.coroutines.experimental.async


class GetNotesUseCase(private val repository: NotesRepository) : UseCase<Unit, List<Note>> {
    override fun execute(params: Unit, listener: UseCaseResult<List<Note>>) {
        async {
            val notes = repository.getList()
            listener.getUseCaseResult(notes)
        }
    }
}