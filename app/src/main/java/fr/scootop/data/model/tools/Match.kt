package fr.scootop.data.model.tools;
import java.util.List;

import fr.scootop.data.model.configuration.Stade;
import fr.scootop.data.model.services.Event;
import fr.scootop.data.model.services.LocationWearable;
import fr.scootop.data.model.user.domain.Scoot;

public class Match {
	
    private Long id;
	
	private Event event;
	
	private Competition competition;
    
    private Team teamA;
    
    
    private Team teamB;
	
	private Stade stade;
	
	private Saison saison;

	private List<StatisticalSheet> statisticalSheetsTeamB;

    private List<StatisticalSheet> statisticalSheetsTeamA;
    

	private List<LocationWearable> wearables;
	
	private List <Scoot> scoots;
	
	
}
