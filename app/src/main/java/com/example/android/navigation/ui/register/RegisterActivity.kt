package com.example.android.navigation.ui.register

import android.content.Context
import android.os.Bundle
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import com.example.android.navigation.R
import com.example.android.navigation.common.EMAIL_REGEX
import com.example.android.navigation.common.onClick
import com.example.android.navigation.common.onTextChanged
import com.example.android.navigation.registerPresenter
import com.example.android.navigation.ui.main.MainActivity
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_welcome.*
import kotlinx.android.synthetic.main.activity_welcome.registerButton
import java.util.regex.Pattern

class RegisterActivity : AppCompatActivity(), RegisterView {

    private val presenter by lazy { registerPresenter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_signup)
        presenter.setView(this)
        initUi()
    }

    private fun initUi() {
        usernameInput.onTextChanged { presenter.onUsernameChanged(it) }
        emailInput.onTextChanged { presenter.onEmailChanged(it) }
        passwordInput.onTextChanged { presenter.onPasswordChanged(it) }
        repeatPasswordInput.onTextChanged { presenter.onRepeatPasswordChanged(it) }

        registerButton.onClick { presenter.onRegisterTapped() }
    }

    enum class EmailErrorType(@StringRes val errorResource: Int) {
        NONE(0),
        EMPTY(R.string.email_empty_error),
        INVALID(R.string.email_error)
    }

    fun getError(context: Context, resource: Int) = if (resource==0) null else context.getString(resource)

    private fun onEmailChanged(email: String): EmailErrorType = when {
        email.isEmpty() -> EmailErrorType.EMPTY
        !Pattern.matches(EMAIL_REGEX, email) -> EmailErrorType.INVALID
        else -> EmailErrorType.NONE
    }

    override fun onRegisterSuccess() = startActivity(MainActivity.getLaunchIntent(this))

    override fun showSignUpError() {
    }

    override fun showUsernameError() {
        usernameInput.error = getString(R.string.username_error)
    }

    override fun showEmailError() {
        emailInput.error = getString(R.string.email_error)
    }

    override fun showPasswordError() {
        passwordInput.error = getString(R.string.password_error)
    }

    override fun showPasswordMatchingError() {
        repeatPasswordInput.error = getString(R.string.repeat_password_error)
    }
}