package com.example.android.navigation.presentation.implementation

import com.example.android.navigation.firebase.authentication.FirebaseAuthenticationInterface
import com.example.android.navigation.firebase.database.FirebaseDatabaseInterface
import com.example.android.navigation.model.Joke
import com.example.android.navigation.presentation.AllJokesPresenter
import com.example.android.navigation.ui.jokes.AllJokesView
import javax.inject.Inject

class AllJokesPresenterImpl @Inject constructor(
        private val authenticationInterface: FirebaseAuthenticationInterface,
        private val databaseInterface: FirebaseDatabaseInterface
) : AllJokesPresenter {

    private lateinit var view: AllJokesView

    override fun setView(view: AllJokesView) {
        this.view = view
    }

    override fun viewReady() {
        getAllJokes()
    }

    override fun getAllJokes() = databaseInterface.listenToJokes { view.addJoke(it) }

    override fun onFavoriteButtonTapped(joke: Joke) {
        databaseInterface.changeJokeFavoriteStatus(joke, authenticationInterface.getUserId())
    }
}