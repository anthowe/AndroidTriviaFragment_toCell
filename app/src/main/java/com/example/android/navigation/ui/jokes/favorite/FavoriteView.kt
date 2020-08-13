package com.example.android.navigation.ui.jokes.favorite

import com.example.android.navigation.model.Joke

interface FavoriteView {

    fun showFavoriteJokes(jokes: List<Joke>)

    fun showNoDataDescription()

    fun hideNoDataDescription()

    fun clearItems()
}