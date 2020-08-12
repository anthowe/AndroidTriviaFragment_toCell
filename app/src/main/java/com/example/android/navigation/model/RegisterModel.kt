package com.example.android.navigation.model

import com.example.android.navigation.common.arePasswordsSame
import com.example.android.navigation.common.isEmailValid
import com.example.android.navigation.common.isUsernameValid

data class RegisterRequest(var name: String = "",
                           var email: String = "",
                           var password: String = "",
                           var repeatPassword: String = "") {

    fun isValid(): Boolean = isUsernameValid(name)
            && isEmailValid(email)
            && arePasswordsSame(password, repeatPassword)
}