package com.example.android.navigation.ui.addJoke

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.android.navigation.R
import com.example.android.navigation.addJokePresenter
import com.example.android.navigation.common.onClick
import com.example.android.navigation.common.onTextChanged
import com.example.android.navigation.common.showGeneralError
import kotlinx.android.synthetic.main.activity_add_joke.*

class AddJokeActivity : AppCompatActivity(), AddJokeView {

    private val presenter by lazy { addJokePresenter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_joke)
        presenter.setView(this)

        initUi()
    }

    private fun initUi() {
        jokeDescription.onTextChanged { presenter.onJokeTextChanged(it) }
        addJoke.onClick { presenter.addJokeTapped() }
    }

    override fun showJokeError() {
        jokeDescription.error = getString(R.string.joke_error)
    }

    override fun removeJokeError() {
        jokeDescription.error = null
    }

    override fun onJokeAdded() = finish()

    override fun showAddJokeError() = showGeneralError(this)
}