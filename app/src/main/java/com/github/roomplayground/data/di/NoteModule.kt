package com.github.roomplayground.data.di

import com.github.roomplayground.data.AppDatabase
import com.github.roomplayground.data.NotesRepositoryImpl
import com.github.roomplayground.domain.*
import com.github.roomplayground.presentation.NotePresenter
import com.github.roomplayground.presentation.NotePresenterImpl
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class NoteModule {
    @Provides
    @ActivityScope
    fun provideRepository(db: AppDatabase): NotesRepository =
            NotesRepositoryImpl(db.noteDao())

    @Provides
    @Named("saveUseCase")
    @ActivityScope
    fun provideUseCase(repository: NotesRepository): UseCase<Note, Note> =
            SaveNoteUseCase(repository)

    @Provides
    @Named("updateUseCase")
    @ActivityScope
    fun provideUpdateUseCase(repository: NotesRepository): UseCase<Note, Note> =
            UpdateNoteUseCase(repository)

    @Provides
    @ActivityScope
    fun providePresenter(
            @Named("saveUseCase") saveUseCase: @JvmSuppressWildcards UseCase<Note, Note>,
            @Named("updateUseCase") updateUseCase: @JvmSuppressWildcards UseCase<Note, Note>
    ): NotePresenter = NotePresenterImpl(saveUseCase, updateUseCase)
}