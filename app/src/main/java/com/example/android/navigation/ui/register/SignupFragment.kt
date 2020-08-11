package com.example.android.navigation.ui.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.android.navigation.R
import com.example.android.navigation.databinding.FragmentSignupBinding


class SignupFragment: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: FragmentSignupBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_signup, container, false)

        binding.registerSuccessButton.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_signupFragment_to_titleFragment)
        }
        return  binding.root
    }


}

