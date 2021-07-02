package fr.scootop.data.model.services.interaction

import fr.scootop.data.model.user.User
import fr.scootop.data.model.user.domain.Player
import java.time.LocalDate

class Invite {
    var id: Long? = null
    var createAt: LocalDate? = null
    var response = false
    var user: User? = User()
    var player: Player? = Player()
}