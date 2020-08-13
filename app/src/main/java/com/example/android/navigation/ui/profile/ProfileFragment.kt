package com.example.android.navigation.ui.profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.android.navigation.R
import com.example.android.navigation.common.onClick
import com.example.android.navigation.profilePresenter
import com.example.android.navigation.ui.welcome.WelcomeActivity
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment(), ProfileView {

    private val presenter by lazy { profilePresenter() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.setView(this)
       // initUi()
    }

    private fun initUi() {
        logoutButton.onClick { presenter.logOut() }
    }

    override fun showUsername(username: String) {
        userName.text = getString(R.string.username_text, username)
    }

    override fun showEmail(email: String) {
        userEmail.text = getString(R.string.email_text, email)
    }

    override fun showNumberOfJokes(jokesCount: Int) {
        numberOfJokes.text = getString(R.string.number_of_jokes_text, jokesCount)
    }

    override fun openWelcome() {
        startActivity(Intent(activity, WelcomeActivity::class.java))
        activity?.finish()
    }
}