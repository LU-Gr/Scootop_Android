package fr.scootop.data.model.user.provider;

import fr.scootop.data.model.user.User;


public class Manager {
	private Long id;
	
	private User user;
	
	@JsonIgnoreProperties("managers")
	private Agence agence;
}
