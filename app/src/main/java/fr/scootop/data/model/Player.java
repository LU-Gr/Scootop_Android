package fr.scootop.data.model;

import androidx.annotation.Nullable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Player
{
	@Expose
	public Integer id;

	@Expose
	@SerializedName("height_cm")
	public Integer heightCm = 0;

	@Expose
	@SerializedName("weight_kg")
	public Float weightKg = 0f;

	@Expose
	public String distinction;

	@Expose
	public String footed;

	@Expose
	@SerializedName("favorite_position")
	@Nullable
	public Position favoritePosition;

	@Expose
	@SerializedName("secondary_position")
	@Nullable
	public Position secondaryPosition;

	@Expose
	public User user;

	@Expose
	@Nullable
	public Team team;

	@Expose
	@Nullable
	public Video video;

	@Expose
	@SerializedName("videos")
	public List<Video> videos = new ArrayList<>();

	@Expose
	@SerializedName("matches_count")
	public int matchesCount = 0;

	@Expose
	@SerializedName("goals_count")
	public int goalsCount = 0;

	@Expose
	@SerializedName("passes_count")
	public int passesCount = 0;

	@Expose
	@SerializedName("skills_count")
	public int skillsCount = 0;

	@Expose
	@SerializedName("distinctions_count")
	public int distinctionsCount = 0;

	public Player()
	{

	}
}
