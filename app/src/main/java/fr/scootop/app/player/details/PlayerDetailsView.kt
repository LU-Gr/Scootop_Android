package fr.scootop.app.player.details

import android.content.Context
import fr.scootop.data.model.user.domain.Player

interface PlayerDetailsView {

    fun getContext(): Context

    fun displayPlayer(player: Player)

    fun displayError(message: String)

    fun displayInfo(message: String)

    fun hideInviteAction()

    fun displayLoading()

    fun hideLoading()
}
