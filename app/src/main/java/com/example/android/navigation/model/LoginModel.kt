package com.example.android.navigation.model

import com.example.android.navigation.common.isEmailValid
import com.example.android.navigation.common.isPasswordValid

data class LoginRequest(var email: String = "",
                        var password: String = "") {

    fun isValid() = isEmailValid(email) && isPasswordValid(password)
}