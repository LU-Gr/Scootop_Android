package fr.scootop.data.model.configuration;
import java.util.List;

import fr.scootop.data.model.user.domain.Player;


public class Poste {
	
	private Long id;
	
	private String name;
	
	@JsonIgnoreProperties({"postes","statisticalSheets"})
	private List<Player> players;
}
