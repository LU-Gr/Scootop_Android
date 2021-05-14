package fr.scootop.app.register.user

import fr.scootop.app.common.vip.LoadingPresenter
import java.lang.ref.WeakReference

class RegisterObserverPresenter(view: RegisterView) : LoadingPresenter {
    
    private val mView: WeakReference<RegisterView> = WeakReference(view)

    override fun presentLoading() {
        mView.get()?.showLoading()
    }

    override fun dismissLoading() {
        mView.get()?.hideLoading()
    }

    fun presentHome() {
        mView.get()?.displayHome()
    }

    fun presentError(message: String) {
        mView.get()?.displayError(message)
    }
}
