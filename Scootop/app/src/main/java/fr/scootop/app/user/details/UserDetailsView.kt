package fr.scootop.app.user.details

import fr.scootop.app.common.vip.LoadingView

interface UserDetailsView : LoadingView {

    fun displayUser(any: Any)

    fun displayError(message: String)
}
