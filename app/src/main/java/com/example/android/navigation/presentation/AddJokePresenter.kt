package com.example.android.navigation.presentation

import com.example.android.navigation.presentation.implementation.BasePresenter
import com.example.android.navigation.ui.addJoke.AddJokeView


interface AddJokePresenter : BasePresenter<AddJokeView> {

    fun addJokeTapped()

    fun onJokeTextChanged(jokeText: String)
}