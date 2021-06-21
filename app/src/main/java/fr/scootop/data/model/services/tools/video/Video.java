package fr.scootop.data.model.services.tools.video;import java.util.Date;
import java.util.List;

import com.projet.scootop.domain.user.domain.Player;
import com.projet.scootop.model.configuration.CompetitionType;
import fr.scootop.data.model.services.Event;


public class Video {
    private Long id;
    
    @JsonIgnoreProperties({"videos","statisticalSheets"})
    private Player player;
    
    private String url;
    
    private Date posted;
    
    
    @JsonIgnoreProperties("videos")
    private Event event;
    
    private CompetitionType competitionType;
    
    @JsonIgnoreProperties("video")
    private List<VideoView> views;
    
    
    @JsonIgnoreProperties("videos")
    private List<SearchKeyWord> keywords;
}