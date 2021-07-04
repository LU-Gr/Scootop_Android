package fr.scootop.data.model.tools

import fr.scootop.data.model.user.Contact
import fr.scootop.data.model.user.domain.Scoot

class Club {
    var id: Long? = null
    var colorInside: String? = null
    var colorOutSide: String? = null
    var name: String = ""
    var contact: Contact? = null
    var teams: List<Team>? = null
    var scoots: List<Scoot>? = null
    override fun toString(): String {
        return name
    }

}