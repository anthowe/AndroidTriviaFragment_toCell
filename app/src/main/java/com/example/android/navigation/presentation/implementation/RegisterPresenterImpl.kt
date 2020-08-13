package com.example.android.navigation.presentation

import com.example.android.navigation.common.arePasswordsSame
import com.example.android.navigation.common.isEmailValid
import com.example.android.navigation.common.isPasswordValid
import com.example.android.navigation.common.isUsernameValid
import com.example.android.navigation.firebase.authentication.FirebaseAuthenticationInterface
import com.example.android.navigation.firebase.database.FirebaseDatabaseInterface
import com.example.android.navigation.model.RegisterRequest
import com.example.android.navigation.presentation.implementation.RegisterPresenter
import com.example.android.navigation.ui.register.RegisterView
import javax.inject.Inject

class RegisterPresenterImpl @Inject constructor(
        private val database: FirebaseDatabaseInterface,
        private val authentication: FirebaseAuthenticationInterface) : RegisterPresenter {

    private lateinit var view: RegisterView

    private val userData = RegisterRequest()

    override fun setView(view: RegisterView) {
        this.view = view
    }

    override fun onUsernameChanged(username: String) {
        userData.name = username

        if (!isUsernameValid(username)) {
            view.showUsernameError()
        }
    }

    override fun onEmailChanged(email: String) {
        userData.email = email

        if (!isEmailValid(email)) {
            view.showEmailError()
        }
    }

    override fun onPasswordChanged(password: String) {
        userData.password = password

        if (!isPasswordValid(password)) {
            view.showPasswordError()
        }
    }

    override fun onRepeatPasswordChanged(repeatPassword: String) {
        userData.repeatPassword = repeatPassword

        if (!arePasswordsSame(userData.password, repeatPassword)) {
            view.showPasswordMatchingError()
        }
    }

    override fun onRegisterTapped() {
        if (userData.isValid()) {
            val (name, email, password) = userData

            authentication.register(email, password, name) { isSuccessful ->
                onRegisterResult(isSuccessful, name, email)
            }
        }
    }

    private fun onRegisterResult(isSuccessful: Boolean, name: String, email: String) {
        if (isSuccessful) {
            createUser(name, email)
            view.onRegisterSuccess()
        } else {
            view.showSignUpError()
        }
    }

    private fun createUser(name: String, email: String) {
        val id = authentication.getUserId()

        database.createUser(id, name, email)
    }
}