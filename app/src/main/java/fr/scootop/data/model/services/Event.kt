package fr.scootop.data.model.services;
import java.time.LocalDate;
import java.util.List;

import fr.scootop.data.model.services.tools.video.Video;
import fr.scootop.data.model.tools.Competition;
import fr.scootop.data.model.tools.Saison;
import fr.scootop.data.model.tools.Team;
import fr.scootop.data.model.user.domain.Scoot;
import fr.scootop.data.model.user.provider.Analyste;
import fr.scootop.data.model.user.provider.Cameraman;


public class Event {
	private Long id;
	
	private LocalDate date;
	
	private boolean status;
	
    private boolean prestaWearable;
    
    private boolean prestaZoom;
    

    private List<Video> videos;
	
	private Competition competition;
	
	private Saison saison;
	
	private List <Team> teams;
	
	private List <Scoot> scoots;
	
    private List<Analyste> analysts;
    
    
    private List<Cameraman> cameramans;
}
