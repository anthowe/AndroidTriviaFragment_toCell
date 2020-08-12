package com.example.android.navigation.presentation.implementation

import com.example.android.navigation.ui.register.RegisterView

interface RegisterPresenter : BasePresenter<RegisterView> {

    fun onUsernameChanged(username: String)

    fun onEmailChanged(email: String)

    fun onPasswordChanged(password: String)

    fun onRepeatPasswordChanged(repeatPassword: String)

    fun onRegisterTapped()

}