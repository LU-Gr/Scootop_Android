package fr.scootop.data.model.services;
import com.projet.scootop.model.configuration.CompetitionType;
import fr.scootop.data.model.tools.Saison;
import fr.scootop.data.model.tools.Team;
import lombok.Getter;

public class ComparatorParams {
	 
	private Saison saison;
	
	private CompetitionType competitionType;
	
	private Team team;
	
	private Long playerAId;
	
	private Long playerBId;
}
