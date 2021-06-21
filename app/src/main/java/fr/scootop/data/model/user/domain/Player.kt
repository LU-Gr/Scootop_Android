package fr.scootop.data.model.user.domain

import fr.scootop.data.model.Category
import fr.scootop.data.model.Video
import fr.scootop.data.model.configuration.Poste
import fr.scootop.data.model.tools.StatisticalSheet
import fr.scootop.data.model.tools.Team
import fr.scootop.data.model.user.User

data class Player(
    val id: Long? = null,
    val rating: Int = 0,
    val taille: Int = 0,
    val poids: Int = 0,
    val vma: Int = 0,
    val nationalite: String? = null,
    val origin: String? = null,
    val isSelected: Boolean = false,
    val isSubstitute: Boolean = false,
    val interaction: Int = 0,
    val strongFoot: String? = null,
    val weekFoot: String? = null,
    val photoUrl: String? = null,
    val user: User? = null,
    val category: Category? = null,
    val statisticalSheets: List<StatisticalSheet>? = null,
    val videos: List<Video>? = null,
    val teams: List<Team>? = null,
    val postes: List<Poste>? = null
)

