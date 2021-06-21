package fr.scootop.data.model.user.domain;

import fr.scootop.data.model.configuration.CompetitionType;
import fr.scootop.data.model.tools.Saison;
import fr.scootop.data.model.tools.Team;

public class FicheJoueur {
	 
	private Saison saison;
	
	private CompetitionType competitionType;
	
	private Team team;
	
	private String playerFirstName;
	
	private String playerLastName;
	
	private String photoUrl;

	private int nbPasses;

	private int nbShoots;

	private int nbSkills;
	
	private int nbMatchPlayed;
	
	private int nbMinutePlayed;
	
	private int nbGoals;
	
	private int nbSuccededPasses;
	
	private int nbShootsInBox;

	public Saison getSaison() {
		return saison;
	}

	public void setSaison(Saison saison) {
		this.saison = saison;
	}

	public CompetitionType getCompetitionType() {
		return competitionType;
	}

	public void setCompetitionType(CompetitionType competitionType) {
		this.competitionType = competitionType;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public String getPlayerFirstName() {
		return playerFirstName;
	}

	public void setPlayerFirstName(String playerFirstName) {
		this.playerFirstName = playerFirstName;
	}

	public String getPlayerLastName() {
		return playerLastName;
	}

	public void setPlayerLastName(String playerLastName) {
		this.playerLastName = playerLastName;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public int getNbPasses() {
		return nbPasses;
	}

	public void setNbPasses(int nbPasses) {
		this.nbPasses = nbPasses;
	}

	public int getNbShoots() {
		return nbShoots;
	}

	public void setNbShoots(int nbShoots) {
		this.nbShoots = nbShoots;
	}

	public int getNbSkills() {
		return nbSkills;
	}

	public void setNbSkills(int nbSkills) {
		this.nbSkills = nbSkills;
	}

	public int getNbMatchPlayed() {
		return nbMatchPlayed;
	}

	public void setNbMatchPlayed(int nbMatchPlayed) {
		this.nbMatchPlayed = nbMatchPlayed;
	}

	public int getNbMinutePlayed() {
		return nbMinutePlayed;
	}

	public void setNbMinutePlayed(int nbMinutePlayed) {
		this.nbMinutePlayed = nbMinutePlayed;
	}

	public int getNbGoals() {
		return nbGoals;
	}

	public void setNbGoals(int nbGoals) {
		this.nbGoals = nbGoals;
	}

	public int getNbSuccededPasses() {
		return nbSuccededPasses;
	}

	public void setNbSuccededPasses(int nbSuccededPasses) {
		this.nbSuccededPasses = nbSuccededPasses;
	}

	public int getNbShootsInBox() {
		return nbShootsInBox;
	}

	public void setNbShootsInBox(int nbShootsInBox) {
		this.nbShootsInBox = nbShootsInBox;
	}

	public int getNbSuccededDribbles() {
		return nbSuccededDribbles;
	}

	public void setNbSuccededDribbles(int nbSuccededDribbles) {
		this.nbSuccededDribbles = nbSuccededDribbles;
	}

	public int getNbBallonsRecuperes() {
		return nbBallonsRecuperes;
	}

	public void setNbBallonsRecuperes(int nbBallonsRecuperes) {
		this.nbBallonsRecuperes = nbBallonsRecuperes;
	}

	private int nbSuccededDribbles;
	
	private int nbBallonsRecuperes;
}
