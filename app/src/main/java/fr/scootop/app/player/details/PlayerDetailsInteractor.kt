package fr.scootop.app.player.details

import android.content.Context
import fr.scootop.data.api.ApiManager
import fr.scootop.data.model.services.interaction.Invite
import fr.scootop.data.model.user.domain.Player
import fr.scootop.data.storage.UserStorage
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class PlayerDetailsInteractor(
    private val mPresenter: PlayerDetailsPresenter,
    context: Context
) {

    private var mContext = context
    private var mPlayer: Player? = null

    fun isFollowing(): Boolean? {
        return mPlayer?.user?.isFollowing
    }

    fun loadPlayer(playerId: Long?) {
        /** s'il manque l'id du joueur alors nous ne pouvons pas le charger, alors ERREUR  */
        if (playerId == null) {
            mPresenter.presentError("Joueur introuvable")
            return
        }

        mPresenter.presentLoading()

        /** appel de l'API pour récupérer les données détaillées du joueur avec son ID  */
        ApiManager.get().userDomainService.getPlayerById(playerId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ player ->
                mPlayer = player
                mPresenter.dismissLoading()
                mPresenter.presentPlayer(player)
            }) { throwable ->
                mPresenter.dismissLoading()
                mPresenter.presentError(throwable.message ?: throwable.localizedMessage)
            }
    }

    fun alert() {
        /*mPlayer?.id?.let {
            mPresenter.presentLoading()

            ApiManager.get().userService.reportPlayer(it)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ result ->
                    mPresenter.dismissLoading()
                    result.message?.let {
                        mPresenter.presentInfo(it)
                    } ?: run {
                        result.error?.let {
                            mPresenter.presentError(it)
                        }
                    }
                }) { throwable ->
                    mPresenter.dismissLoading()
                    mPresenter.presentError(throwable.message ?: throwable.localizedMessage)
                }
        } ?: run {
            mPresenter.presentError("Impossible d'effectuer cette action.")
        }*/
    }

    fun addToShortlist() {
        /*mPlayer?.user?.id?.let {
            mPresenter.presentLoading()

            val shortlistItem = ShortlistItem()
            shortlistItem.shortlistedUser = "/api/users/" + it

            ApiManager.get().shortlistItemService.addShortlistItem(shortlistItem)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ item ->
                    mPlayer?.user?.isFollowing = true
                    mPlayer?.user?.shortlistItemId = item.id
                    mPresenter.dismissLoading()
                    mPresenter.presentPlayer(mPlayer)
                }) { throwable ->
                    mPresenter.dismissLoading()
                    mPresenter.presentError(throwable.message ?: throwable.localizedMessage)
                }
        } ?: run {
            mPresenter.presentError("Impossible d'effectuer cette action.")
        }*/
    }

    fun removeToShortlist() {
        /*mPlayer?.user?.shortlistItemId?.let {
            mPresenter.presentLoading()

            ApiManager.get().shortlistItemService.deleteShortlistItem(it)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    mPlayer?.user?.isFollowing = false
                    mPlayer?.user?.shortlistItemId = 0
                    mPresenter.dismissLoading()
                    mPresenter.presentPlayer(mPlayer)
                }) { throwable ->
                    mPresenter.dismissLoading()
                    mPresenter.presentError(throwable.message ?: throwable.localizedMessage)
                }
        } ?: run {
            mPresenter.presentError("Impossible d'effectuer cette action.")
        }*/
    }

    fun invite() {
        mPlayer?.id?.let {
            mPresenter.presentLoading()
            var i = Invite()
            i.player!!.id = it
            i.user!!.id = UserStorage.get(mContext).user?.id

            ApiManager.get().serviceInteractionService.addInvite(i)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ result ->
                    mPresenter.dismissLoading()
                    result.message?.let {
                        mPresenter.presentInfo(it)
                    } ?: run {
                        result.error?.let {
                            mPresenter.presentError(it)
                        }
                    }
                }) { throwable ->
                    mPresenter.dismissLoading()
                    mPresenter.presentError(throwable.message ?: throwable.localizedMessage)
                }
        } ?: run {
            mPresenter.presentError("Impossible d'effectuer cette action.")
        }
    }
}
