package com.github.roomplayground.data.di

import com.github.roomplayground.presentation.NoteActivity
import dagger.Component

@Component(modules = [NoteModule::class], dependencies = [AppComponent::class])
@ActivityScope
interface NoteComponent {
    fun inject(activity: NoteActivity)
}