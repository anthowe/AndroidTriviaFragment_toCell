package com.example.android.navigation.presentation.implementation

import com.example.android.navigation.ui.welcome.WelcomeView

interface WelcomePresenter : BasePresenter<WelcomeView> {

    fun viewReady()
}