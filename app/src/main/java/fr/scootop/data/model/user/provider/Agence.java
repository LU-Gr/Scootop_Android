package fr.scootop.data.model.user.provider;
import java.util.List;

public class Agence {
	
    private Long id;
	
	private String region;
	
	@JsonIgnoreProperties("agence")
	private List<MarketingAdvisor> marketingAdvisors;
	
	@JsonIgnoreProperties("agence")
	private List<Manager> manager;
}
