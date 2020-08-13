package com.example.android.navigation.ui.welcome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.android.navigation.R
import com.example.android.navigation.databinding.ActivityWelcomeBinding


class WelcomeActivity: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //return super.onCreateView(inflater, container, savedInstanceState)
        val binding: ActivityWelcomeBinding = DataBindingUtil.inflate(inflater, R.layout.activity_welcome, container, false)

        binding.loginButton.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_welcomeFragment_to_signinFragment)}


            binding.registerButton.setOnClickListener { view: View ->
                view.findNavController().navigate(R.id.action_welcomeFragment_to_signupFragment)
            }

        return binding.root
    }
}

