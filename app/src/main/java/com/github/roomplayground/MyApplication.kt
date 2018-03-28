package com.github.roomplayground

import android.app.Application
import android.arch.persistence.room.Room
import com.github.roomplayground.data.AppDatabase


class MyApplication : Application() {

    private lateinit var db: AppDatabase

    override fun onCreate() {
        super.onCreate()
        setupDb()
    }

    private fun setupDb() {
        db = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "notes-db").build()
    }
}