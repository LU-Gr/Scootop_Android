package fr.scootop.app.register.user

import android.content.Context
import android.text.TextUtils
import android.util.Log
import fr.scootop.data.api.ApiManager
import fr.scootop.data.model.request.AuthRequest
import fr.scootop.data.model.request.RegisterUser
import fr.scootop.data.model.request.RegisterUserObserver
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class RegisterObserverInteractor(private val mPresenter: RegisterObserverPresenter, private val context: Context) : RegisterInteractor(context) {

    fun register(user: RegisterUser) {
        mPresenter.presentLoading()

        val observer = RegisterUserObserver()
        observer.setUser(user)

        ApiManager.get()
            .userService
            .register(user)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ loginResult ->
                handle(loginResult)
                //login(user.email!!, user.password!!)
                mPresenter.presentSearchEngine()
            }) { throwable ->
                mPresenter.dismissLoading()
                mPresenter.presentError(throwable.localizedMessage)
            }
    }

    fun login(email: String, password: String) {
        // temp code
        //mPresenter.presentHome()
        // temp code

        mPresenter.presentLoading()
        var authRequest = AuthRequest()
        authRequest.email = email
        authRequest.password = password
        Log.i("login",authRequest.toString())
        ApiManager.get().userService.login(authRequest)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ loginResult ->
                mPresenter.dismissLoading()
                if (loginResult.code == null && !TextUtils.isEmpty(loginResult.jwt)) {
                    handle(loginResult)
                    mPresenter.presentSearchEngine()
                } else if (loginResult.code != null) {

                    var errorMessage: String
                    if (loginResult.code == 401) {
                        errorMessage = "Email ou mot de passe incorrect"
                    } else {
                        errorMessage = loginResult.message
                    }
                    if (TextUtils.isEmpty(errorMessage)) {
                        errorMessage = "Une erreur s'est produite"
                    }

                    mPresenter.presentError(errorMessage)
                }
            }) { throwable ->
                mPresenter.dismissLoading()

                val errorMessage: String
                if (throwable.localizedMessage.contains("401")) {
                    errorMessage = "Email ou mot de passe incorrect"
                } else {
                    errorMessage = throwable.localizedMessage
                }
                mPresenter.presentError(errorMessage)
            }
    }
}
