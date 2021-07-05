package fr.scootop.app.register.user

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.afollestad.materialdialogs.MaterialDialog
import fr.scootop.R
import fr.scootop.app.common.ExtraKey
import fr.scootop.app.home.HomeActivity
import fr.scootop.app.search.SearchActivity
import fr.scootop.data.definition.UserType
import fr.scootop.data.model.request.RegisterUserPlayer
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity(), RegisterView, View.OnClickListener {

    private var adapter: RegisterStepAdapter? = null

    private var observerInteractor: RegisterObserverInteractor? = null
    private var playerInteractor: RegisterPlayerInteractor? = null

    private var userType: UserType? = null

    private var userPlayer: RegisterUserPlayer? = null

    private var progressDialog: MaterialDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        setSupportActionBar(registerToolbar)

        nextStepButton.setOnClickListener(this)

        userType = UserType.from(intent.extras!!.getString(ExtraKey.USER_TYPE))
        userType?.let {
            adapter = RegisterStepAdapter(supportFragmentManager, it)
            registerViewPager.adapter = adapter

            if (it == UserType.Observer) {
                observerInteractor = RegisterObserverInteractor(RegisterObserverPresenter(this), this)
                previousStepButton.visibility = View.GONE
                nextStepButton.setText(R.string.action_validate)
            } else if (it == UserType.Player) {
                playerInteractor = RegisterPlayerInteractor(RegisterPlayerPresenter(this), this)
                previousStepButton.visibility = View.GONE
                nextStepButton.setText(R.string.action_next)
                userPlayer = RegisterUserPlayer()
            }
        }
    }

    override fun onClick(v: View?) {
        userType?.let { it ->
            when (it) {
                UserType.Observer -> {
                    adapter?.userFragment?.registerUser?.let {
                        if (it.isValid()) {
                            observerInteractor?.register(it)
                        } else {
                            displayError(getString(R.string.toast_form_incomplete))
                        }
                    }
                }
                UserType.Player -> {
                    when (registerViewPager.currentItem) {
                        RegisterStepAdapter.STEP_USER -> {
                            adapter?.userFragment?.registerUser?.let {
                                if (it.isValid()) {
                                    userPlayer?.user = it
                                    registerViewPager.currentItem = RegisterStepAdapter.STEP_PLAYER
                                } else {
                                    displayError(getString(R.string.toast_form_incomplete))
                                }
                            }
                        }
                        RegisterStepAdapter.STEP_PLAYER -> {
                            adapter?.playerFragment?.player?.let { it ->
                                userPlayer?.merge(it)
                                userPlayer?.let {
                                    if (it.isValid()) {
                                        playerInteractor?.register(it)
                                    } else {
                                        displayError(getString(R.string.toast_form_incomplete))
                                    }
                                }
                            }
                        }
                        else -> {}
                    }
                }
                else -> {}
            }
        }
    }

    override fun showLoading() {
        progressDialog = MaterialDialog.Builder(this)
            .title(R.string.dialog_loading_title)
            .content(R.string.dialog_loading_message)
            .progress(true, 0)
            .progressIndeterminateStyle(true)
            .build()
        progressDialog?.show()
    }

    override fun hideLoading() {
        progressDialog?.hide()
    }

    override fun displayError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun displayHome() {
        startActivity(Intent(this, HomeActivity::class.java))
    }

    override fun displaySearchEngine() {
        startActivity(Intent(this, SearchActivity::class.java))
    }
}
