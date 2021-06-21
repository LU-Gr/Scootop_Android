package fr.scootop.data.model.services;

import java.util.List;
import fr.scootop.data.model.tools.Team;
import fr.scootop.data.model.user.User;
import fr.scootop.data.model.user.domain.Player;
import fr.scootop.data.model.user.domain.Scoot;

public class Shortlist {
	
	private Long id;
	
	private int rank;
	
	private User user;
	
	private List <Player> Players;
	
	private List <Scoot> Scoots;
	
	private List <Team> Teams;
	
    
}
