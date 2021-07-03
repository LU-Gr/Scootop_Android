package fr.scootop.data.model.statistics;

import fr.scootop.data.model.configuration.TouchType;
import fr.scootop.data.model.tools.Match;
import fr.scootop.data.model.user.domain.Player;

public class Pass {
	private Long id;
	
	private int minute;
	
    private Boolean decisive;
    
    
    private Boolean isSuccess;
    
    
    private Boolean isLongPass;
    
    
    private Player player;

    private Match match;
    
    
    private TouchType touchType;
}
