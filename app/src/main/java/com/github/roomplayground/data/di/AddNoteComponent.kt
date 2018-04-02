package com.github.roomplayground.data.di

import com.github.roomplayground.presentation.AddNoteActivity
import dagger.Component

@Component(modules = [AddNoteModule::class], dependencies = [AppComponent::class])
@ActivityScope
interface AddNoteComponent {
    fun inject(activity: AddNoteActivity)
}