package com.example.android.navigation.presentation.implementation

interface BasePresenter<in T> {

    fun setView(view: T)
}