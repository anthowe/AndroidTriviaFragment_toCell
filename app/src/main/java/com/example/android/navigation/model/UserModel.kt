package com.example.android.navigation.model

data class UserResponse(val id: String = "",
                        val username: String = "",
                        val email: String = ""
                        )

data class User(val id: String,
                val username: String,
                val email: String
                )