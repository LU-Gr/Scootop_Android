package fr.scootop.data.model.services.interaction;
import java.time.LocalDate;
import fr.scootop.data.model.services.Event;
import fr.scootop.data.model.tools.Saison;
import fr.scootop.data.model.user.User;
import fr.scootop.data.model.user.domain.Player;

public class Invite {
    private Long id;
	
    private LocalDate createAt;
    
    
    private boolean response;
	
	private Saison saison;
    
    
    private Event events;
    
    
    private User user;
    
    
    private Player player;
    
    
   
}
