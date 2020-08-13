package com.example.android.navigation.presentation

import com.example.android.navigation.presentation.implementation.BasePresenter
import com.example.android.navigation.ui.login.LoginView

interface LoginPresenter : BasePresenter<LoginView> {

    fun onLoginTapped()

    fun onEmailChanged(email: String)

    fun onPasswordChanged(password: String)
}