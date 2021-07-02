package fr.scootop.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import fr.scootop.data.model.user.User;


public class LoginResult
{
	// ----- Error case ------
	@Expose
	public Integer code;
	@Expose
	public String message;

	// ----- Success case -----
	@Expose
	@SerializedName("token")
	public String jwt;
	@Expose
	@SerializedName("refresh_token")
	public String refreshToken;
	@Expose
	public User user;

	public LoginResult()
	{
	}
}
