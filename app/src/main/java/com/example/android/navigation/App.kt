package com.example.android.navigation

import android.app.Application
import com.example.android.navigation.di.AppComponent
import com.example.android.navigation.di.DaggerAppComponent

class App : Application() {

    companion object {
        lateinit var instance: App
            private set

        val component: AppComponent by lazy { DaggerAppComponent.builder().build() }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}