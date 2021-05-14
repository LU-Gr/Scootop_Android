package fr.scootop.app.login

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import fr.scootop.R
import fr.scootop.app.home.HomeActivity
import fr.scootop.app.register.type.RegisterTypeActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), LoginView {

    internal var mProgressDialog: ProgressDialog? = null

    private var mInteractor: LoginInteractor? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        mInteractor = LoginInteractor(LoginPresenter(this), this)

        logInButton.setOnClickListener {
            val email = emailInput.text.toString()
            val password = passwordInput.text.toString()

            if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
                Toast.makeText(this, R.string.form_login_error_missing_field, Toast.LENGTH_LONG).show()
            } else {
                mInteractor?.login(email, password)
            }
        }

        signInButton.setOnClickListener {
            startActivity(Intent(this, RegisterTypeActivity::class.java))
        }
    }

    override fun showLoading() {
        mProgressDialog = ProgressDialog.show(this, getString(R.string.dialog_loading_title), getString(R.string.dialog_loading_message), true)
    }

    override fun hideLoading() {
        mProgressDialog?.dismiss()
    }

    override fun displayHomePage() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }

    override fun displayError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
