package fr.scootop.data.model.tools

import fr.scootop.data.model.configuration.Category
import fr.scootop.data.model.configuration.CompetitionType
import fr.scootop.data.model.user.domain.Coach
import fr.scootop.data.model.user.domain.Player

class Team {
    var id: Long? = null
    var name: String = ""
    var club: Club? = null
    var competitionType: CompetitionType? = null
    var category: Category? = null
    var coaches: List<Coach>? = null
    var players: List<Player>? = null
    override fun toString(): String {
        return name
    }
}