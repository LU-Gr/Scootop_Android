package fr.scootop.data.model.services.tools.video;
import java.util.Date;
import java.util.List;

import fr.scootop.data.model.configuration.CompetitionType;
import fr.scootop.data.model.services.Event;
import fr.scootop.data.model.user.domain.Player;


public class Video {
    private Long id;

    private Player player;
    
    private String url;
    
    private Date posted;
    

    private Event event;
    
    private CompetitionType competitionType;

    private List<VideoView> views;
    

    private List<SearchKeyWord> keywords;
}