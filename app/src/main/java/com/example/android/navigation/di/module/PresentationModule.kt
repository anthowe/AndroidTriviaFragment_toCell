package com.example.android.navigation.di.module

import com.example.android.navigation.presentation.LoginPresenter
import com.example.android.navigation.presentation.LoginPresenterImpl
import com.example.android.navigation.presentation.RegisterPresenterImpl
import com.example.android.navigation.presentation.WelcomePresenterImpl
import com.example.android.navigation.presentation.implementation.RegisterPresenter
import com.example.android.navigation.presentation.implementation.WelcomePresenter
import dagger.Binds
import dagger.Module

@Module(includes = [InteractionModule::class])
abstract class PresentationModule {

    @Binds
    abstract fun loginPresenter(loginPresenter: LoginPresenterImpl): LoginPresenter

    @Binds
    abstract fun registerPresenter(registerPresenter: RegisterPresenterImpl): RegisterPresenter

    @Binds
    abstract fun welcomePresenter(welcomePresenterImpl: WelcomePresenterImpl): WelcomePresenter
}