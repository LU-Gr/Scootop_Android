package fr.scootop.data.model.user.domain;import java.util.List;

import fr.scootop.data.model.tools.Team;
import fr.scootop.data.model.user.User;


public class Coach {
    private Long id;
	
    private User user;

    private List<Team> teams;
}
