package fr.scootop.data.model.statistics;

import com.projet.scootop.model.configuration.TouchType;
import fr.scootop.data.model.tools.Match;
import fr.scootop.data.model.user.domain.Player;


public class Shoot {
	private Long id;
	
    private int minute;
	
    private Boolean isFreeKick;
    
    
    private Boolean isPenaltyBox;
    
    
    private Boolean isGoal;
    
    
    private Boolean isLongShoot;
    
    
    private Boolean isInBox;
	
	@JsonIgnoreProperties({"match"})
	private Pass pass;
	
	@JsonIgnoreProperties({"statisticalSheetsTeamA","statisticalSheetsTeamB"})
	private Match match;
	
	private TouchType touchType;
	
	private Player player;
}
