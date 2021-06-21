package fr.scootop.data.model.tools;

import fr.scootop.data.model.configuration.CompetitionType;

public class Competition {
	
	private Long id;	
	
	private String name;
	
	private int playerMax;
	
	private int playerMin;
	private int nbTitulaire;
	
	private int nbRemplacant;
	private int nbSubstition;
	
	private int dureeMiTemps;
	
	private CompetitionType competitionType;
}
