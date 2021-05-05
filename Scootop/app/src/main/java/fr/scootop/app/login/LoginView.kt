package fr.scootop.app.login

import fr.scootop.app.common.vip.LoadingView

interface LoginView : LoadingView {
    fun displayHomePage()

    fun displayError(message: String)
}
