package fr.scootop.data.model.services.tools.video;
import java.time.LocalDate;

import fr.scootop.data.model.user.User;

public class VideoView {
    
    private Long id;
    
    
    private LocalDate date;
    
    @JsonIgnoreProperties("views")
    private Video video;
    
    
    private User user;
}