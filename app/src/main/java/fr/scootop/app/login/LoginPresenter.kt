package fr.scootop.app.login

import fr.scootop.app.common.vip.LoadingPresenter
import java.lang.ref.WeakReference

class LoginPresenter(view: LoginView) : LoadingPresenter {

    private val mView: WeakReference<LoginView> = WeakReference(view)

    override fun presentLoading() {
        mView.get()?.showLoading()
    }

    override fun dismissLoading() {
        mView.get()?.hideLoading()
    }

    fun presentHome() {
        mView.get()?.displayHomePage()
    }

    fun presentError(message: String) {
        mView.get()?.displayError(message)
    }

    fun presentSearchEngine() {
        mView.get()?.displaySearchEngine()
    }
}
