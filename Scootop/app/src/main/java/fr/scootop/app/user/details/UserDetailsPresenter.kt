package fr.scootop.app.user.details

import java.lang.ref.WeakReference

class UserDetailsPresenter(v: UserDetailsView) {

    private val view = WeakReference<UserDetailsView>(v)

    fun presentLoading() {
        view.get()?.showLoading()
    }

    fun dismissLoading() {
        view.get()?.hideLoading()
    }

    fun presentError(message: String) {
        view.get()?.displayError(message)
    }

}