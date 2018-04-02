package com.github.roomplayground.data

import com.github.roomplayground.presentation.NotesActivity
import dagger.Component

@Component(modules = [NotesModule::class])
interface NotesComponent {
    fun inject(activity: NotesActivity)
}