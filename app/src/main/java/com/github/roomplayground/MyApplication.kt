package com.github.roomplayground

import android.app.Application
import com.github.roomplayground.data.di.AppComponent
import com.github.roomplayground.data.di.AppModule
import com.github.roomplayground.data.di.DaggerAppComponent


class MyApplication : Application() {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        injectDependencies()
    }

    private fun injectDependencies() {
        appComponent = DaggerAppComponent.builder().appModule(AppModule(applicationContext)).build()
    }

    fun getAppComponent(): AppComponent = appComponent
}