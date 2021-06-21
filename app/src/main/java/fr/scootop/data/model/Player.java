package fr.scootop.data.model;
import androidx.annotation.Nullable;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;


public class Player
{
	public Integer id;

	@SerializedName("height_cm")
	public Integer heightCm = 0;

	@SerializedName("weight_kg")

	public Float weightKg = 0f;

	public String distinction;

	public String footed;

	@SerializedName("favorite_position")
	@Nullable
	public Position favoritePosition;

	@SerializedName("secondary_position")
	@Nullable
	public Position secondaryPosition;

	public User user;

	@Nullable
	public Team team;

	@Nullable
	public Video video;

	@SerializedName("videos")
	public List<Video> videos = new ArrayList<>();

	@SerializedName("matches_count")
	public int matchesCount = 0;

	@SerializedName("goals_count")
	public int goalsCount = 0;

	@SerializedName("passes_count")
	public int passesCount = 0;

	@SerializedName("skills_count")
	public int skillsCount = 0;

	@SerializedName("distinctions_count")
	public int distinctionsCount = 0;

	public Player()
	{

	}
}
