package fr.scootop.data.model.tools;
import java.util.List;

import fr.scootop.data.model.user.Contact;
import fr.scootop.data.model.user.domain.Scoot;



public class Club {
	
	private Long id;
	
    private String colorInside;
	
	private String colorOutSide;
	
	private String name;
	
	private Contact contact;

	private List<Team> teams;
	
	private List<Scoot> scoots;
}
