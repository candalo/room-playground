package com.github.roomplayground.data.di

import com.github.roomplayground.data.AppDatabase
import dagger.Component
import javax.inject.Singleton

@Component(modules = [AppModule::class])
@Singleton
interface AppComponent {
    fun createAppDatabase(): AppDatabase
}