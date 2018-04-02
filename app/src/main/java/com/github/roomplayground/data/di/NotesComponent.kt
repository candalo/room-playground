package com.github.roomplayground.data.di

import com.github.roomplayground.presentation.NotesActivity
import dagger.Component

@Component(modules = [NotesModule::class], dependencies = [AppComponent::class])
@ActivityScope
interface NotesComponent {
    fun inject(activity: NotesActivity)
}