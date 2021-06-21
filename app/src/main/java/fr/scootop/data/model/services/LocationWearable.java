package fr.scootop.data.model.services;

import fr.scootop.data.model.tools.Match;
import fr.scootop.data.model.tools.Team;
import fr.scootop.data.model.user.domain.Player;

public class LocationWearable {
	
    private Long id;
    
    
    private Player player;
    
    private Team team;
    
    
    @JsonIgnoreProperties("wearables")
    private Match match;
    
    
    private Integer distanceRun;
    
    
    private Integer distancePlay;
    
    
    private Integer vMax;
    
    
    private Integer vMaxWithBall;
    
    
    private Integer ballPlay;
    
    
    private Integer looseBall;
    
    
    private Integer ballRecovered;
    
    
    private Integer tackle;
    
    
    private Integer foulSuffered;
    
    
    private Integer failPass;
    
    
    private Integer assist;
    
    
    private Integer shortPass;
    
    
    private Integer head;
    
    
    private Integer headOffensive;
    
    
    private Integer headDefensive;
    
    
    private Integer shots;
    
    
    private Integer shotOnTarget;
    
    
    private Integer shotOffTarget;
    
    
    private Integer longShot;
    
    
    private Integer successSkill;
    
    
    private Integer failSkill;
}
