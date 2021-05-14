package fr.scootop.app.youtube.picker

import fr.scootop.data.model.youtube.YTSearchResult
import java.lang.ref.WeakReference

class YTVideoPickerPresenter(v: YTVideoPickerView) {

    private val view = WeakReference<YTVideoPickerView>(v)

    fun presentLoading() {
        view.get()?.displayLoading()
    }

    fun dismissLoading() {
        view.get()?.hideLoading()
    }

    fun presentItems(items: Array<YTSearchResult>) {
        view.get()?.displayItems(items)
    }

    fun presentError(message: String) {
        view.get()?.displayError(message)
    }

    fun dismissPicker() {
        view.get()?.successfulDismiss()
    }
}