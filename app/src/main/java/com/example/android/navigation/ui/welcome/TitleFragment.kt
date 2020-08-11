package com.example.android.navigation.ui.welcome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.android.navigation.R
import com.example.android.navigation.databinding.FragmentTitleBinding

class TitleFragment: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentTitleBinding>(inflater,
                R.layout.fragment_title,container,false)

        binding.attImage.setOnClickListener {viewATT: View ->
            viewATT.findNavController().navigate(R.id.action_titleFragment_to_attFragment)}

        binding.verizonImage.setOnClickListener{viewVerizon : View ->
            viewVerizon.findNavController().navigate(R.id.action_titleFragment_to_verizonFragment)
        }



        return binding.root
    }
}