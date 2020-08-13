package com.example.android.navigation.firebase.database

import com.example.android.navigation.model.Joke
import com.example.android.navigation.model.User

interface FirebaseDatabaseInterface {

    fun listenToJokes(onResult: (Joke) -> Unit)

    fun addNewJoke(joke: Joke, onResult: (Boolean) -> Unit)

    fun changeJokeFavoriteStatus(joke: Joke, userId: String)

    fun getFavoriteJokes(userId: String, onResult: (List<Joke>) -> Unit)

    fun createUser(id: String, name: String, email: String)

    fun getProfile(id: String, onResult: (User) -> Unit)
}
