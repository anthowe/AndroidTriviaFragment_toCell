package com.example.android.navigation.presentation

import com.example.android.navigation.firebase.authentication.FirebaseAuthenticationInterface
import com.example.android.navigation.presentation.implementation.WelcomePresenter
import com.example.android.navigation.ui.welcome.WelcomeView
import javax.inject.Inject

class WelcomePresenterImpl @Inject constructor(
        private val authenticationInterface: FirebaseAuthenticationInterface

) : WelcomePresenter {

    private lateinit var view: WelcomeView

    override fun setView(view: WelcomeView) {
        this.view = view
    }

    override fun viewReady() {
        if (authenticationInterface.getUserId().isNotBlank()) {
            view.startMainScreen()
        }
    }
}

