package fr.scootop.data.model.tools;
import java.time.LocalDate;
import java.util.List;


public class Saison {
    private Integer id;
	
    private LocalDate dateDebut;
	
    private LocalDate dateFin;

    private List<Match> matchs;
}
