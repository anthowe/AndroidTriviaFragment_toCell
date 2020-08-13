package com.example.android.navigation.presentation

import com.example.android.navigation.model.Joke
import com.example.android.navigation.presentation.implementation.BasePresenter
import com.example.android.navigation.ui.jokes.AllJokesView

interface AllJokesPresenter : BasePresenter<AllJokesView> {

    fun viewReady()

    fun getAllJokes()

    fun onFavoriteButtonTapped(joke: Joke)
}