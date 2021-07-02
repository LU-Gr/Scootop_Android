package fr.scootop.data.model.user.domain

import fr.scootop.data.model.configuration.CompetitionType
import fr.scootop.data.model.tools.Saison
import fr.scootop.data.model.tools.Team

class FicheJoueur {
    var saison: Saison? = null
    var competitionType: CompetitionType? = null
    var team: Team? = null
    var playerFirstName: String? = null
    var playerLastName: String? = null
    var photoUrl: String? = null
    var nbPasses = 0
    var nbShoots = 0
    var nbAssists = 0
    var nbSkills = 0
    var nbSucceededSkills =0
    var nbMatchPlayed = 0
    var nbMatchWon = 0
    var nbMinutePlayed = 0
    var nbGoals = 0
    var nbSuccededPasses = 0
    var nbShootsInBox = 0
    var nbSuccededDribbles = 0
    var nbBallsRecuperes = 0
    var nbBallsLost = 0
    var nbBallsPlayed = 0
}