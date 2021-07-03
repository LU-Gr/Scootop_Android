package fr.scootop.data.model.configuration;
import java.util.List;

import fr.scootop.data.model.tools.Saison;


public class League {
	
    private Long id;
	
	private String name;

	private List<Division> divisions;
	
    private CompetitionType competitionType;
	
	private Saison saison;
}
