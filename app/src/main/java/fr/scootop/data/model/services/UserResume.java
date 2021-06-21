package fr.scootop.data.model.services;
import java.util.List;
import fr.scootop.data.model.tools.Competition;
import fr.scootop.data.model.tools.Saison;
import fr.scootop.data.model.tools.StatisticalSheet;
import fr.scootop.data.model.tools.Team;
import fr.scootop.data.model.user.domain.Player;

public class UserResume {
    private Long id;
	
	private int rank;
	private Player player;
    
    
    private Competition competitionType;
    
    
    private List<StatisticalSheet> statisticalSheets;
    
    
    private List<Saison> saisons;
    
    
    private List<Team> teams;
}
