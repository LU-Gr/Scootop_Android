package fr.scootop.app.post.create

import fr.scootop.data.api.ApiManager
import fr.scootop.data.model.Post
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import java.text.SimpleDateFormat
import java.util.*

class CreatePostInteractor(private val presenter: CreatePostPresenter) {

    private val dateFormat = SimpleDateFormat("YYYY-MM-dd HH:mm:ss", Locale.getDefault())

    fun createPost(text: String, address: String, date: Date) {
        presenter.presentLoading()

        val post = Post()
        post.text = text
        post.address = address
        post.date = dateFormat.format(date)

        ApiManager.get().postService.createPost(post)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ _ ->
                presenter.dismissLoading()
                presenter.presentDashboard()
            }) { throwable ->
                presenter.dismissLoading()
                presenter.presentError(throwable.message ?: throwable.localizedMessage)
            }
    }
}