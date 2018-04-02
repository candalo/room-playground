package com.github.roomplayground.data

import com.github.roomplayground.presentation.NotesPresenter
import com.github.roomplayground.presentation.NotesPresenterImpl
import dagger.Module
import dagger.Provides

@Module
class NotesModule {
    @Provides
    fun providePresenter(): NotesPresenter = NotesPresenterImpl()
}