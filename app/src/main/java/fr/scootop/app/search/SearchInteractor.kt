package fr.scootop.app.search

import android.text.TextUtils
import fr.scootop.data.api.ApiManager.Companion.get
import fr.scootop.data.model.user.domain.SearchPlayer
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class SearchInteractor(private val mPresenter: SearchPresenter) {
    var sp = SearchPlayer()
    fun search(text: String) {
        /** si le texte est vide, on ne fait pas la rechercher avec l'API  */
        if (TextUtils.isEmpty(text)) {
            mPresenter.presentPlayers(null)
            return
        }
        if (text.length < 4) {
            return
        }
        sp.name = text
        /** appel de l'API pour recherche les joueurs correspondant au texte  */
        get().userDomainService
            .searchPlayer(sp)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe ({ searchList ->
                /** en cas de succès  */
                mPresenter.presentPlayers(searchList)
            }) { throwable ->
                /** en cas d'erreur  */
                mPresenter.presentError(throwable.message)
            }
    }
}