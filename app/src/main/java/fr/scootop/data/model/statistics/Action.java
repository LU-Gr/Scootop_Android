package fr.scootop.data.model.statistics;

import com.projet.scootop.model.configuration.ActionType;
import fr.scootop.data.model.tools.Match;
import fr.scootop.data.model.user.domain.Player;


public class Action {
	private Long id;
	
	private int minute;
	
	private Boolean isDefensive;
	
	private Boolean isSuccessful;
	
    private ActionType actionType;
	
	@JsonIgnoreProperties({"statisticalSheetsTeamA","statisticalSheetsTeamB"})
	private Match match;
	
	private Player player;
	
}
