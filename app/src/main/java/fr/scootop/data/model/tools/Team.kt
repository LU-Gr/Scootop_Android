package fr.scootop.data.model.tools

import fr.scootop.data.model.configuration.Category
import fr.scootop.data.model.configuration.CompetitionType
import fr.scootop.data.model.user.domain.Coach
import fr.scootop.data.model.user.domain.Player

class Team {
    val id: Long? = null
    val name: String? = null


    val club: Club? = null
    val competitionType: CompetitionType? = null
    val category: Category? = null

    val coaches: List<Coach>? = null
    val players: List<Player>? = null
}