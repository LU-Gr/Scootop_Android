package fr.scootop.app.user.details

import fr.scootop.data.api.ApiManager
import fr.scootop.data.model.User

class UserDetailsInteractor(private val presenter: UserDetailsPresenter) {

    fun loadUser(user: User) {
        ApiManager.get().userService
    }

}