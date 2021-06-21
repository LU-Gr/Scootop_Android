package fr.scootop.data.model.configuration;


public class Division {
	
    private Long id;
	
    private String name;
	   
    
    @JsonIgnoreProperties("divisions")
    private League league;
     
    
    private Category category;
}
