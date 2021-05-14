package fr.scootop.app.post.create

import fr.scootop.app.common.ILoadingView
import fr.scootop.app.common.IMessagingView

interface CreatePostView: ILoadingView, IMessagingView {

    fun onPostCreated()
}
