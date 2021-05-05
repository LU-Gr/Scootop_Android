package fr.scootop.app.youtube.picker

import fr.scootop.data.api.ApiManager
import fr.scootop.data.model.request.CreateVideo
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class YTVideoPickerInteractor(private val presenter: YTVideoPickerPresenter) {

    fun searchVideos(query: String) {
        if (query.length > 3) {
            ApiManager.get().youtubeServce.searchVideos(query)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ result ->
                    presenter.presentItems(result.items)
                }) { throwable ->
                    presenter.presentError(throwable.message ?: throwable.localizedMessage)
                }

        } else {
            presenter.presentItems(emptyArray())
        }
    }

    fun attachVideo(youtubeId: String) {
        presenter.presentLoading()

        ApiManager.get().videoService.createVideo(CreateVideo(youtubeId))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ _ ->
                presenter.dismissLoading()
                presenter.dismissPicker()
            }) { throwable ->
                presenter.dismissLoading()
                presenter.presentError(throwable.message ?: throwable.localizedMessage)
            }
    }

}