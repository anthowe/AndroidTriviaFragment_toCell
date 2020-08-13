package com.example.android.navigation.di

import com.example.android.navigation.di.module.PresentationModule
import com.example.android.navigation.presentation.AddJokePresenter
import com.example.android.navigation.presentation.AllJokesPresenter
import com.example.android.navigation.presentation.FavoriteJokesPresenter
import com.example.android.navigation.presentation.LoginPresenter
import com.example.android.navigation.presentation.implementation.ProfilePresenter
import com.example.android.navigation.presentation.implementation.RegisterPresenter
import com.example.android.navigation.presentation.implementation.WelcomePresenter
import dagger.Component
import javax.inject.Singleton

@Component(modules = [PresentationModule::class])
@Singleton
interface AppComponent {

    fun registerPresenter(): RegisterPresenter

    fun loginPresenter(): LoginPresenter

   fun allJokesPresenter(): AllJokesPresenter

   fun favoriteJokesPresenter(): FavoriteJokesPresenter

    fun profilePresenter(): ProfilePresenter

   fun addJokePresenter(): AddJokePresenter

    fun welcomePresenter(): WelcomePresenter
}