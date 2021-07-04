package fr.scootop.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import fr.scootop.data.model.user.User;


public class LoginResult
{
	@Override
	public String toString() {
		return "LoginResult{" +
				"code=" + code +
				", message='" + message + '\'' +
				", jwt='" + jwt + '\'' +
				", user=" + user +
				'}';
	}

	// ----- Error case ------
	@Expose
	public Integer code;
	@Expose
	public String message;

	// ----- Success case -----
	@Expose
	public String jwt;

	@Expose
	public User user;

	public LoginResult()
	{
	}
}
