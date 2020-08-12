package com.example.android.navigation.firebase.database

import android.util.Log
import com.example.android.navigation.model.User
import com.google.firebase.database.FirebaseDatabase
import javax.inject.Inject
import com.example.android.navigation.presentation.implementation.ProfilePresenter

private const val KEY_USER = "user"
private const val KEY_JOKE = "joke"
private const val KEY_FAVORITE = "favorite"

class FirebaseDatabaseManager @Inject constructor(private val database: FirebaseDatabase) : FirebaseDatabaseInterface {

    override fun createUser(id: String, name: String, email: String) {
        val user = User(id, name, email)
        Log.i("Activity", "FDM called")
        database
                .reference        // 1
                .child(KEY_USER)  // 2
                .child(id)        // 3
                .setValue(user)   // 4
    }

    override fun getProfile(id: String, onResult: (User) -> Unit) {
    }


}