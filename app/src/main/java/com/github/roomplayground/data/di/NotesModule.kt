package com.github.roomplayground.data.di

import com.github.roomplayground.data.AppDatabase
import com.github.roomplayground.data.NotesRepositoryImpl
import com.github.roomplayground.domain.GetNotesUseCase
import com.github.roomplayground.domain.Note
import com.github.roomplayground.domain.NotesRepository
import com.github.roomplayground.domain.UseCase
import com.github.roomplayground.presentation.NotesPresenter
import com.github.roomplayground.presentation.NotesPresenterImpl
import dagger.Module
import dagger.Provides

@Module
class NotesModule {
    @Provides
    @ActivityScope
    fun provideRepository(db: AppDatabase): NotesRepository =
            NotesRepositoryImpl(db.noteDao())

    @Provides
    @ActivityScope
    fun provideUseCase(repository: NotesRepository): UseCase<Unit, List<Note>> =
            GetNotesUseCase(repository)

    @Provides
    @ActivityScope
    fun providePresenter(usecase: @JvmSuppressWildcards UseCase<Unit, List<Note>>): NotesPresenter =
            NotesPresenterImpl(usecase)
}