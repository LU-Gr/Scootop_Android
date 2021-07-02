package fr.scootop.data.model.user.domain

import fr.scootop.data.model.Category
import fr.scootop.data.model.Video
import fr.scootop.data.model.configuration.Poste
import fr.scootop.data.model.tools.StatisticalSheet
import fr.scootop.data.model.tools.Team
import fr.scootop.data.model.user.User

data class Player(
    var id: Long? = null,
    var rating: Int = 0,
    var taille: Int = 0,
    var poids: Int = 0,
    var vma: Int = 0,
    var nationalite: String? = null,
    var origin: String? = null,
    var isSelected: Boolean = false,
    var isSubstitute: Boolean = false,
    var interaction: Int = 0,
    var strongFoot: String? = null,
    var weekFoot: String? = null,
    var photoUrl: String? = null,
    var user: User? = null,
    var category: Category? = null,
    var statisticalSheets: List<StatisticalSheet>? = null,
    var videos: List<Video>? = null,
    var teams: List<Team>? = null,
    var postes: List<Poste>? = null
)

