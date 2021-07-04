package fr.scootop.data.model.configuration

import fr.scootop.data.model.user.domain.Player

class Poste {
    val id: Long? = null
    val name: String = ""
    val players: List<Player>? = null
    override fun toString(): String {
        return name
    }


}