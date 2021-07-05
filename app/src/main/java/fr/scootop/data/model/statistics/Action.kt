package fr.scootop.data.model.statistics;

import fr.scootop.data.model.configuration.ActionType;
import fr.scootop.data.model.tools.Match;
import fr.scootop.data.model.user.domain.Player;


public class Action {
	private Long id;
	
	private int minute;
	
	private Boolean isDefensive;
	
	private Boolean isSuccessful;
	
    private ActionType actionType;

	private Match match;
	
	private Player player;
	
}
