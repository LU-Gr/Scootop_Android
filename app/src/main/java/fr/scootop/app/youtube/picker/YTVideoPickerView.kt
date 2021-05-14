package fr.scootop.app.youtube.picker

import fr.scootop.app.common.ILoadingView
import fr.scootop.app.common.IMessagingView
import fr.scootop.data.model.youtube.YTSearchResult

interface YTVideoPickerView: ILoadingView, IMessagingView {

    fun displayItems(items: Array<YTSearchResult>)

    fun successfulDismiss()
}
