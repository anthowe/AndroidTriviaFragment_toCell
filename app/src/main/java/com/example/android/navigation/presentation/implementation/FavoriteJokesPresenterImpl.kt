package com.example.android.navigation.presentation.implementation

import com.example.android.navigation.firebase.authentication.FirebaseAuthenticationInterface
import com.example.android.navigation.firebase.database.FirebaseDatabaseInterface
import com.example.android.navigation.model.Joke
import com.example.android.navigation.presentation.FavoriteJokesPresenter
import com.example.android.navigation.ui.jokes.favorite.FavoriteView
import javax.inject.Inject

class FavoriteJokesPresenterImpl @Inject constructor(
        private val authenticationInterface: FirebaseAuthenticationInterface,
        private val databaseInterface: FirebaseDatabaseInterface
) : FavoriteJokesPresenter {

    private lateinit var view: FavoriteView

    override fun setView(view: FavoriteView) {
        this.view = view
    }

    override fun getFavoriteJokes() {
        val id = authenticationInterface.getUserId()

        databaseInterface.getFavoriteJokes(id) {
            it.forEach { it.isFavorite = true }

            displayItems(it)
        }
    }

    private fun displayItems(items: List<Joke>) {
        if (items.isEmpty()) {
            view.clearItems()
            view.showNoDataDescription()
        } else {
            view.hideNoDataDescription()
            view.showFavoriteJokes(items)
        }
    }

    override fun onFavoriteButtonTapped(joke: Joke) {
        databaseInterface.changeJokeFavoriteStatus(joke, authenticationInterface.getUserId())
    }
}