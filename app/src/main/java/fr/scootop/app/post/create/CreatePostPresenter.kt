package fr.scootop.app.post.create

import java.lang.ref.WeakReference

class CreatePostPresenter(v: CreatePostView) {

    private val view = WeakReference<CreatePostView>(v)

    fun presentLoading() {
        view.get()?.displayLoading()
    }

    fun dismissLoading() {
        view.get()?.hideLoading()
    }

    fun presentDashboard() {
        view.get()?.onPostCreated()
    }

    fun presentError(message: String) {
        view.get()?.displayError(message)
    }
}
