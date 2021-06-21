package fr.scootop.data.model.tools;
import java.util.List;

import com.projet.scootop.model.configuration.Stade;
import com.projet.scootop.model.services.Event;
import com.projet.scootop.model.services.LocationWearable;
import fr.scootop.data.model.user.domain.Scoot;

public class Match {
	
    private Long id;
	
	private Event event;
	
	private Competition competition;
    
    private Team teamA;
    
    
    private Team teamB;
	
	private Stade stade;
	
	private Saison saison;
	
	@JsonIgnoreProperties("match")
	private List<StatisticalSheet> statisticalSheetsTeamB;
    
    @JsonIgnoreProperties("match")
    private List<StatisticalSheet> statisticalSheetsTeamA;
    
    
    @JsonIgnoreProperties("match")
	private List<LocationWearable> wearables;
	
	private List <Scoot> scoots;
	
	
}
