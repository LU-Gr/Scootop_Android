package fr.scootop.app.register.user

import android.util.Log
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
        Log.w("error register",message)
        mView.get()?.displayError(message)
    }

    fun presentSearchEngine() {
        mView.get()?.displaySearchEngine()
    }
}
