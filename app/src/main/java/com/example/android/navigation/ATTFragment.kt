/*
 * Copyright 2018, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.viewbinding.BuildConfig
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.android.navigation.R.layout.fragment_att
import com.example.android.navigation.databinding.FragmentAttBinding

class ATTFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding: FragmentAttBinding = DataBindingUtil.inflate(
                inflater, fragment_att, container, false)

        binding.backButton.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_attFragment_to_titleFragment)

        }
        binding.buybutton.setOnClickListener {view: View ->
        view.findNavController().navigate(R.id.action_attImage_to_blankFragment)}

        return binding.root


    }


}

