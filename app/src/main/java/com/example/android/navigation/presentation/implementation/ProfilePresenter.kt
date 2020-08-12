package com.example.android.navigation.presentation.implementation

import com.example.android.navigation.ui.profile.ProfileView

interface ProfilePresenter : BasePresenter<ProfileView> {

    fun getProfile()

    fun logOut()
}