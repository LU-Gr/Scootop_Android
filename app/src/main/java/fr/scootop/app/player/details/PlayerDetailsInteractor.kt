package fr.scootop.app.player.details

import fr.scootop.data.api.ApiManager
import fr.scootop.data.model.Player
import fr.scootop.data.model.PlayerSearchItem
import fr.scootop.data.model.ShortlistItem
import rx.android.schedulers.AndroidSchedulers
import rx.functions.Action1
import rx.schedulers.Schedulers

class PlayerDetailsInteractor(private val mPresenter: PlayerDetailsPresenter) {

    private var mPlayer: Player? = null

    fun isFollowing(): Boolean? {
        return mPlayer?.user?.isFollowing
    }

    fun loadPlayer(playerId: Int?) {
        /** s'il manque l'id du joueur alors nous ne pouvons pas le charger, alors ERREUR  */
        if (playerId == null) {
            mPresenter.presentError("Joueur introuvable")
            return
        }

        mPresenter.presentLoading()

        /** appel de l'API pour récupérer les données détaillées du joueur avec son ID  */
        ApiManager.get().userService.getPlayer(playerId)
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
        mPlayer?.id?.let {
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
        }
    }

    fun addToShortlist() {
        mPlayer?.user?.id?.let {
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
        }
    }

    fun removeToShortlist() {
        mPlayer?.user?.shortlistItemId?.let {
            mPresenter.presentLoading()

            ApiManager.get().shortlistItemService.deleteShortlistItem(it)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    mPlayer?.user?.isFollowing = false
                    mPlayer?.user?.shortlistItemId = null
                    mPresenter.dismissLoading()
                    mPresenter.presentPlayer(mPlayer)
                }) { throwable ->
                    mPresenter.dismissLoading()
                    mPresenter.presentError(throwable.message ?: throwable.localizedMessage)
                }
        } ?: run {
            mPresenter.presentError("Impossible d'effectuer cette action.")
        }
    }

    fun invite() {
        mPlayer?.id?.let {
            mPresenter.presentLoading()

            ApiManager.get().userService.invitePlayer(it)
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
