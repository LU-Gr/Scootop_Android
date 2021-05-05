package fr.scootop.data.storage;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;

import java.lang.ref.WeakReference;

public final class TokenStorage
{
	private static final String NAME = "TokenStorage";
	private static final String KEY_JWT = "_jwt";
	private static final String KEY_REFRESH_TOKEN = "_refresh_token";
	private static final String KEY_DEVICE_TOKEN = "_device_token";

	private static TokenStorage instance;

	private WeakReference<Context> context;

	private TokenStorage()
	{
	}

	public static TokenStorage get(Context context)
	{
		if (null == instance) {
			instance = new TokenStorage();
		}
		instance.context = new WeakReference<>(context);
		return instance;
	}

	public boolean setJWT(@Nullable String jwt)
	{
		return getPrefs().edit().putString(KEY_JWT, jwt).commit();
	}

	@Nullable
	public String getJWT()
	{
		return getPrefs().getString(KEY_JWT, null);
	}

	public boolean setRefreshToken(@Nullable String refreshToken)
	{
		return getPrefs().edit().putString(KEY_REFRESH_TOKEN, refreshToken).commit();
	}

	@Nullable
	public String getRefreshToken()
	{
		return getPrefs().getString(KEY_REFRESH_TOKEN, null);
	}

	public boolean setDeviceToken(@Nullable String token)
	{
		return getPrefs().edit().putString(KEY_DEVICE_TOKEN, token).commit();
	}

	@Nullable
	public String getDeviceToken()
	{
		return getPrefs().getString(KEY_DEVICE_TOKEN, null);
	}

	public boolean clear()
	{
		return getPrefs().edit().clear().commit();
	}

	private SharedPreferences getPrefs()
	{
		return context.get().getSharedPreferences(NAME, Context.MODE_PRIVATE);
	}
}
