package fr.scootop.data.model.statistics;

import com.projet.scootop.model.configuration.TouchType;
import fr.scootop.data.model.tools.Match;
import fr.scootop.data.model.user.domain.Player;

public class Pass {
	private Long id;
	
	private int minute;
	
    private Boolean decisive;
    
    
    private Boolean isSuccess;
    
    
    private Boolean isLongPass;
    
    
    private Player player;
	
	@JsonIgnoreProperties({"statisticalSheetsTeamA","statisticalSheetsTeamB"})
    private Match match;
    
    
    private TouchType touchType;
}
