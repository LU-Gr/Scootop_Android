package fr.scootop.app.player.details

import fr.scootop.data.definition.UserType
import fr.scootop.data.model.Player
import fr.scootop.data.storage.UserStorage
import java.lang.ref.WeakReference

class PlayerDetailsPresenter(view: PlayerDetailsView) {

    private val mView: WeakReference<PlayerDetailsView> = WeakReference(view)

    fun presentPlayer(player: Player?) {
        player?.let {
            mView.get()?.displayPlayer(it)

            mView.get()?.getContext()?.let {
                if (UserStorage.get(it)?.user?.type == UserType.Player.value) {
                    mView.get()?.hideInviteAction()
                }
            }
        } ?: run {
            mView.get()?.displayError("Une erreur s'est produite lors du chargement du joueur !")
        }
    }

    fun presentError(message: String) {
        mView.get()?.displayError(message)
    }

    fun presentLoading() {
        mView.get()?.displayLoading()
    }

    fun presentInfo(message: String) {
        mView.get()?.displayInfo(message)
    }

    fun dismissLoading() {
        mView.get()?.hideLoading()
    }
}