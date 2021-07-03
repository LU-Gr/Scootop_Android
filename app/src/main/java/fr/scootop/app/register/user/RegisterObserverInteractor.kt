package fr.scootop.app.register.user

import android.content.Context
import fr.scootop.data.api.ApiManager
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
                handle(loginResult, user.email)
                mPresenter.dismissLoading()
                mPresenter.presentHome()
            }) { throwable ->
                mPresenter.dismissLoading()
                mPresenter.presentError(throwable.localizedMessage)
            }
    }
}
