package com.example.android.navigation.ui.jokes

import com.example.android.navigation.model.Joke

interface AllJokesView {

    fun showNoDataDescription()

    fun hideNoDataDescription()

    fun addJoke(joke: Joke)

    fun setFavoriteJokesIds(favoriteJokesIds : List<String>)
}