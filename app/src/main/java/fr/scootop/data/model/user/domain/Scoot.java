package fr.scootop.data.model.user.domain;
import java.util.List;

import com.projet.scootop.model.services.Shortlist;
import fr.scootop.data.model.tools.Club;
import fr.scootop.data.model.user.User;

public class Scoot {
	
    private Long id;
	
    private User user;
	
	 @JsonIgnoreProperties({"scoots","user"})
    private Shortlist shortlist;
	
    private List<Club> clubs;
	
    private List<Shortlist> followedShortlists;
}
