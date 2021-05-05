package fr.scootop.data.storage;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;

import com.google.gson.Gson;

import java.lang.ref.WeakReference;

import fr.scootop.data.model.User;

public final class UserStorage
{
    private static final String NAME = "UserStorage";
    private static final String KEY_USER = "_user_json";

    private static UserStorage instance;

    private WeakReference<Context> context;

    private UserStorage()
    {
    }

    public static UserStorage get(Context context)
    {
        if (null == instance) {
            instance = new UserStorage();
        }
        instance.context = new WeakReference<>(context);
        return instance;
    }

    public boolean setUser(@Nullable User user)
    {
        return getPrefs().edit().putString(KEY_USER, new Gson().toJson(user)).commit();
    }

    @Nullable
    public User getUser()
    {
        String userJSON = getPrefs().getString(KEY_USER, null);
        if (userJSON == null) {
            return null;
        }

        return new Gson().fromJson(userJSON, User.class);
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
