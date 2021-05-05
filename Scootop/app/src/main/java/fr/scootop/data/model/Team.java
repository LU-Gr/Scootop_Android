package fr.scootop.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Team
{
	@Expose
	public Integer id;

	@Expose
	@SerializedName("picture_name")
	public String pictureName;

	@Expose
	public String name;

	@Expose
	public List<Player> players;
}
