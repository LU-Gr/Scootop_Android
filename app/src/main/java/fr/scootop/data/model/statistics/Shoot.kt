package fr.scootop.data.model.statistics;

import fr.scootop.data.model.configuration.TouchType;
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

	private Pass pass;

	private Match match;
	
	private TouchType touchType;
	
	private Player player;
}
