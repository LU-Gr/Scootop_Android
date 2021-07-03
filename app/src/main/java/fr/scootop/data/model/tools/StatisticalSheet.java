package fr.scootop.data.model.tools;
import java.util.List;

import fr.scootop.data.model.services.Event;
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
    

    private Match match;
    
    
    private Event event;

    private Player player;

    private Team team;
    

    private List<Shoot> Shoots;
    

    private List<Pass> passes;
    

    private List<Action> actions;
    

    private List<Goal> goals;
    
   
}
