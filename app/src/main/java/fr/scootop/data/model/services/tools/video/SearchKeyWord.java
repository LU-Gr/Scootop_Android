package fr.scootop.data.model.services.tools.video;
import java.util.List;


public class SearchKeyWord {
	
	private Long id;
	
    private String name;
	
	@JsonIgnoreProperties("keywords")
    private List<Video> videos;
}
