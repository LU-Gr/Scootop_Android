package fr.scootop.data.model.statistics;
import java.time.LocalDate;

import fr.scootop.data.model.tools.Match;
import fr.scootop.data.model.user.domain.Player;

public class Goal {
	private Long id;
	
	private LocalDate date;
	
	private Integer rating;
	
	@JsonIgnoreProperties({"match"})
	private Shoot shoot;
	
	@JsonIgnoreProperties({"statisticalSheetsTeamA","statisticalSheetsTeamB"})
    private Match match;
	
    private Player player;
}