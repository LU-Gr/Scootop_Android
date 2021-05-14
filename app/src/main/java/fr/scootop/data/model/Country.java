package fr.scootop.data.model;

import androidx.annotation.Nullable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Country
{
	@Expose
	public Integer id;

	@Expose
	public String name;

	@Expose
	public String code;

	/**
	 * People name is nationality ("française" for France)
	 */
	@Expose
	@SerializedName("people_name")
	@Nullable
	public String peopleName;

	public Country()
	{

	}
}