package com.example.android.navigation.firebase.database

import com.example.android.navigation.model.User

interface FirebaseDatabaseInterface {



    fun createUser(id: String, name: String, email: String)

    fun getProfile(id: String, onResult: (User) -> Unit)
}
