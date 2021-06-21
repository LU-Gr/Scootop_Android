package fr.scootop.data.model.user.provider;

import fr.scootop.data.model.user.User;

public class MarketingAdvisor {
	
	private Long id;
	
	private User user;
	
	@JsonIgnoreProperties("marketingAdvisors")
	private Agence agence;
}
