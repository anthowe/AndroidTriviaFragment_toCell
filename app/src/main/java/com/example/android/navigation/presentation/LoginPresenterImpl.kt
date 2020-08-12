package com.example.android.navigation.presentation

import com.example.android.navigation.common.isEmailValid
import com.example.android.navigation.common.isPasswordValid
import com.example.android.navigation.firebase.authentication.FirebaseAuthenticationInterface
import com.example.android.navigation.model.LoginRequest
import com.example.android.navigation.ui.login.LoginView
import javax.inject.Inject

class LoginPresenterImpl @Inject constructor(
        private val authentication: FirebaseAuthenticationInterface
) : LoginPresenter {

    private lateinit var view: LoginView

    private val loginRequest = LoginRequest()

    override fun setView(view: LoginView) {
        this.view = view
    }

    override fun onLoginTapped() {
        if (loginRequest.isValid()) {
            authentication.login(loginRequest.email, loginRequest.password) { isSuccess ->
                if (isSuccess) {
                    view.onLoginSuccess()
                } else {
                    view.showLoginError()
                }
            }
        }
    }

    override fun onEmailChanged(email: String) {
        loginRequest.email = email

        if (!isEmailValid(email)) {
            view.showEmailError()
        }
    }

    override fun onPasswordChanged(password: String) {
        loginRequest.password = password

        if (!isPasswordValid(password)) {
            view.showPasswordError()
        }
    }
}
