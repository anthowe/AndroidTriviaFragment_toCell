package com.example.android.navigation.presentation

import com.example.android.navigation.model.Joke
import com.example.android.navigation.presentation.implementation.BasePresenter
import com.example.android.navigation.ui.jokes.favorite.FavoriteView

interface FavoriteJokesPresenter : BasePresenter<FavoriteView> {

    fun getFavoriteJokes()

    fun onFavoriteButtonTapped(joke: Joke)
}