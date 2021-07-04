package fr.scootop.app.register.user

import android.content.Context
import fr.scootop.data.api.ApiManager
import fr.scootop.data.model.request.RegisterUserPlayer
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class RegisterPlayerInteractor(private val mPresenter: RegisterPlayerPresenter, context: Context) : RegisterInteractor(context) {

    fun register(player: RegisterUserPlayer) {
        mPresenter.presentLoading()

        ApiManager.get()
            .registerService
            .register(player)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ loginResult ->
                handle(loginResult)
                mPresenter.dismissLoading()
                mPresenter.presentHome()
            }) { throwable ->
                mPresenter.dismissLoading()
                mPresenter.presentError(throwable.localizedMessage)
            }
    }
}