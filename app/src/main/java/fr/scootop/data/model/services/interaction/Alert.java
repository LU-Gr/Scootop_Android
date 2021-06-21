package fr.scootop.data.model.services.interaction;
import java.time.LocalDate;
import fr.scootop.data.model.tools.Saison;
import fr.scootop.data.model.user.User;
import fr.scootop.data.model.user.domain.Player;

public class Alert {
	
	private Long id;
	
	private LocalDate dateCreated;
	
	private User user;
    
    
    private Player player;
    
    
    private Saison saison;
}
