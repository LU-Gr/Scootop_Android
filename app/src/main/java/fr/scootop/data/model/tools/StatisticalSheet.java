package fr.scootop.data.model.tools;
import java.util.List;

import com.projet.scootop.model.services.Event;
import fr.scootop.data.model.statistics.Action;
import fr.scootop.data.model.statistics.Goal;
import fr.scootop.data.model.statistics.Pass;
import fr.scootop.data.model.statistics.Shoot;
import fr.scootop.data.model.user.domain.Player;

public class StatisticalSheet {
	
    private Long id;	
    private int nbBallplayed;
	
    private int nbBalllost;
    
    
    private int nbBallSuccess;
    
    
    private float distancekm;
    
    
    @JsonIgnoreProperties({"statisticalSheetsTeamA","statisticalSheetsTeamB","event"})
    private Match match;
    
    
    private Event event;
	
	@JsonIgnoreProperties({"statisticalSheets","teams"})
    private Player player;
	
	@JsonIgnoreProperties("players")
    private Team team;
    
    
    @JsonIgnoreProperties({"match", "player"})
    private List<Shoot> Shoots;
    
    
    @JsonIgnoreProperties({"match", "player"})
    private List<Pass> passes;
    
    
    @JsonIgnoreProperties({"match", "player"})
    private List<Action> actions;
    
    
    @JsonIgnoreProperties({"match", "player"})
    private List<Goal> goals;
    
   
}
