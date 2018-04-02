package com.github.roomplayground.data.di

import com.github.roomplayground.data.AppDatabase
import com.github.roomplayground.data.NotesRepositoryImpl
import com.github.roomplayground.domain.Note
import com.github.roomplayground.domain.NotesRepository
import com.github.roomplayground.domain.SaveNoteUseCase
import com.github.roomplayground.domain.UseCase
import com.github.roomplayground.presentation.AddNotePresenter
import com.github.roomplayground.presentation.AddNotePresenterImpl
import dagger.Module
import dagger.Provides

@Module
class AddNoteModule {
    @Provides
    @ActivityScope
    fun provideRepository(db: AppDatabase): NotesRepository =
            NotesRepositoryImpl(db.noteDao())

    @Provides
    @ActivityScope
    fun provideUseCase(repository: NotesRepository): UseCase<Note, Note> =
            SaveNoteUseCase(repository)

    @Provides
    @ActivityScope
    fun providePresenter(usecase: @JvmSuppressWildcards UseCase<Note, Note>): AddNotePresenter =
            AddNotePresenterImpl(usecase)
}