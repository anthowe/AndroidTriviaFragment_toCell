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

package com.example.android.navigation.ui.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.android.navigation.R
import com.example.android.navigation.common.onPageChange
import com.example.android.navigation.ui.main.pager.MainPagerAdapter
import com.example.android.navigation.ui.welcome.WelcomeActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    companion object {
        fun getLaunchIntent(from: Context) = Intent(from, MainActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initUi()
    }

    private fun initUi() {
        val adapter = MainPagerAdapter(supportFragmentManager)
       adapter.setPages(listOf(WelcomeActivity()))

        mainPager.adapter = adapter
        mainPager.offscreenPageLimit = 3
        bottomNavigation.setOnNavigationItemSelectedListener {
            switchNavigationTab(it.order)
            true
        }

        mainPager.onPageChange { position ->
            val item = bottomNavigation.menu.getItem(position)

            bottomNavigation.selectedItemId = item.itemId
        }

       // addJoke.onClick { startActivity(Intent(this, AddJokeActivity::class.java)) }
    }

    private fun switchNavigationTab(position: Int) = mainPager.setCurrentItem(position, true)
}





    // TODO (01) Create the new TitleFragment
    // Select File->New->Fragment->Fragment (Blank)

    // TODO (02) Clean up the new TitleFragment
    // In our new TitleFragment

    // TODO (03) Use DataBindingUtil.inflate to inflate and return the titleFragment in onCreateView
    // In our new TitleFragment
    // R.layout.fragment_title

