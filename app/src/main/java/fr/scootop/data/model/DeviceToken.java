package fr.scootop.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DeviceToken extends HydraResource
{
    private static final int TYPE_ANDROID = 1;

    @Expose
    public String token;

    @Expose
    @SerializedName("user")
    public String userIri;

    @Expose
    public int type = TYPE_ANDROID;

    public DeviceToken()
    {
    }

    public DeviceToken(String token)
    {
        this.token = token;
    }
}
