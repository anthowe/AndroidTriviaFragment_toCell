package com.example.android.navigation.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.android.navigation.R
import com.example.android.navigation.databinding.FragmentSigninBinding

class SigninFragment: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: FragmentSigninBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_signin, container, false)

        binding.signupButton.setOnClickListener { view: View->
            view.findNavController().navigate(R.id.action_signinFragment_to_titleFragment)
        }
return binding.root
        //super.onCreateView(inflater, container, savedInstanceState)
    }
}